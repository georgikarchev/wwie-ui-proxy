package com.whatwillieat.wwie_ui_proxy.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.clients.UsersClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
