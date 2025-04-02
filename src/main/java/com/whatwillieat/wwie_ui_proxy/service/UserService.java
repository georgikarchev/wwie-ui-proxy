package com.whatwillieat.wwie_ui_proxy.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.clients.UserClient;
import com.whatwillieat.wwie_ui_proxy.util.SecurityUtil;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserClient userClient;

    @Value("${app.wwie-users.api-key}")
    private String apiKey;

    public String login(ObjectNode rawRequest) {
        log.info("Calling users service for login...");
        ResponseEntity<String> response = userClient.login(apiKey, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public String register(ObjectNode rawRequest) {
        try {
            log.info("Calling users service for register...");
            ResponseEntity<String> response = userClient.register(apiKey, rawRequest);
            log.info("Response status: {}", response.getStatusCode()); // Log the status
            log.info("Received response: {}", response.getBody());
            return response.getBody();
        } catch (FeignException.BadRequest e) {
            log.info("Received error response: {}", e.contentUTF8());
//            return e.contentUTF8();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or email already taken");
        }
    }

    public Object getUser() {
        UUID userIdFromJwt = SecurityUtil.getAuthenticatedUserId();
        log.info("Calling users service for getUser...");
        ResponseEntity<Object> response = userClient.getUser(apiKey, userIdFromJwt);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object getUsers() {
        UUID userIdFromJwt = SecurityUtil.getAuthenticatedUserId();

        if (!isAdmin(userIdFromJwt)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }
        log.info("Calling users service for getUsers...");
        ResponseEntity<Object> response = userClient.getUsers(apiKey);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object updateMe(ObjectNode rawRequest) {
        UUID userIdFromJwt = SecurityUtil.getAuthenticatedUserId();
        log.info("Calling users service for updateUser...");
        ResponseEntity<Object> response = userClient.updateUser(apiKey, userIdFromJwt, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object deleteUser(UUID userId) {
        log.info("Calling users service for deleteUser...");
        ResponseEntity<Object> response = userClient.deleteUser(apiKey, userId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public boolean isAdmin(UUID userId) {
        log.info("Calling users service for isAdmin...");
        ResponseEntity<Object> response = userClient.isAdmin(apiKey, userId);
        log.info("Received response: {}", response.getBody());

        Object body = response.getBody();
        if (body instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) body;
            return (boolean) map.getOrDefault("isAdmin", false);
        }
        throw new IllegalStateException("Invalid response from users service");
    }

    public void deleteUserByAdmin(UUID userId) {
        UUID userIdFromJwt = SecurityUtil.getAuthenticatedUserId();

        if (!isAdmin(userIdFromJwt)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }

        deleteUser(userId);
    }

    public Object updateUserRole(UUID userId, ObjectNode rawRequest) {
        UUID userIdFromJwt = SecurityUtil.getAuthenticatedUserId();

        if (!isAdmin(userIdFromJwt)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }

        log.info("Calling users service for updateUserRole...");
        ResponseEntity<Object> response = userClient.updateUserRole(apiKey, userId, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

}
