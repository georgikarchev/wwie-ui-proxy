package com.whatwillieat.wwie_ui_proxy.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.clients.UsersClient;
import com.whatwillieat.wwie_ui_proxy.util.SecurityUtil;
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
public class UsersService {

    private final UsersClient usersClient;

    @Value("${app.wwie-users.api-key}")
    private String apiKey;

    public String login(ObjectNode rawRequest) {
        log.info("Calling users service for login...");
        ResponseEntity<String> response = usersClient.login(apiKey, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public String register(ObjectNode rawRequest) {
        log.info("Calling users service for register...");
        ResponseEntity<String> response = usersClient.register(apiKey, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object getUser() {
        UUID userIdFromJwt = SecurityUtil.getAuthenticatedUserId();
        log.info("Calling users service for getUser...");
        ResponseEntity<Object> response = usersClient.getUser(apiKey, userIdFromJwt);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object deleteUser(UUID userId) {
        log.info("Calling users service for deleteUser...");
        ResponseEntity<Object> response = usersClient.deleteUser(apiKey, userId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public boolean isAdmin(UUID userId) {
        log.info("Calling users service for isAdmin...");
        ResponseEntity<Object> response = usersClient.isAdmin(apiKey, userId);
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

}
