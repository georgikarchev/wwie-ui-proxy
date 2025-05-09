package com.whatwillieat.wwie_ui_proxy.clients;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "users-service", url = "${app.wwie-users.url}", configuration = FeignClientConfig.class)
public interface UserClient {
    @PostMapping("/users/login")
    ResponseEntity<String> login(@RequestHeader("X-API-KEY") String apiKey, @RequestBody ObjectNode rawRequest);

    @PostMapping("/users/register")
    ResponseEntity<String> register(@RequestHeader("X-API-KEY") String apiKey, @RequestBody ObjectNode rawRequest);

    @GetMapping("/users/{userId}")
    ResponseEntity<Object> getUser(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID userId);

    @GetMapping("/users")
    ResponseEntity<Object> getUsers(@RequestHeader("X-API-KEY") String apiKey);

    @DeleteMapping("/users/{userId}")
    ResponseEntity<Object> deleteUser(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID userId);

    @GetMapping("/users/{userId}/is-admin")
    ResponseEntity<Object> isAdmin(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID userId);

    @PutMapping("/users/{userId}")
    ResponseEntity<Object> updateUser(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID userId, @RequestBody ObjectNode rawRequest);

    @PutMapping("/users/{userId}/role")
    ResponseEntity<Object> updateUserRole(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID userId, @RequestBody ObjectNode rawRequest);
}


