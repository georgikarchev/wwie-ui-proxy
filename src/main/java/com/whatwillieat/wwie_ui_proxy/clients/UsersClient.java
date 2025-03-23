package com.whatwillieat.wwie_ui_proxy.clients;

import com.whatwillieat.wwie_ui_proxy.dto.UserLoginRequest;
import com.whatwillieat.wwie_ui_proxy.dto.UserRegistrationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "users-service", url = "http://localhost:8084/api/v1/users")
public interface UsersClient {
    @PostMapping("/login")
    ResponseEntity<String> login(@RequestHeader("X-API-KEY") String apiKey, @RequestBody UserLoginRequest request);

    @PostMapping("/register")
    ResponseEntity<String> register(@RequestHeader("X-API-KEY") String apiKey, @RequestBody UserRegistrationRequest request);
}


