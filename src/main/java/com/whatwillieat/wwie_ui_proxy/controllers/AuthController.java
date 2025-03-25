package com.whatwillieat.wwie_ui_proxy.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.service.UsersService;
import com.whatwillieat.wwie_ui_proxy.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${app.API_V1_BASE_URL}/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(usersService.login(rawRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(usersService.register(rawRequest));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        UUID userId = SecurityUtil.getAuthenticatedUserId();
        return ResponseEntity.ok("User ID: " + userId);
    }
}
