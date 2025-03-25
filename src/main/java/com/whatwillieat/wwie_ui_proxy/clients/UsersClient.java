package com.whatwillieat.wwie_ui_proxy.clients;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "users-service", url = "${app.wwie-users.url}")
public interface UsersClient {
    @PostMapping("/users/login")
    ResponseEntity<String> login(@RequestHeader("X-API-KEY") String apiKey, @RequestBody ObjectNode rawRequest);

    @PostMapping("/users/register")
    ResponseEntity<String> register(@RequestHeader("X-API-KEY") String apiKey, @RequestBody ObjectNode rawRequest);
}


