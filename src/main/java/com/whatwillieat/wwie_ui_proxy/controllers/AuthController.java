package com.whatwillieat.wwie_ui_proxy.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.service.UserService;
import com.whatwillieat.wwie_ui_proxy.util.SecurityUtil;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${app.API_V1_BASE_URL}/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(userService.login(rawRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(userService.register(rawRequest));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        UUID userId = SecurityUtil.getAuthenticatedUserId();
        return ResponseEntity.ok("User ID: " + userId);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignExceptions(FeignException e) {
        log.error("FeignException: {}", e.contentUTF8());
        return ResponseEntity.status(e.status()).body(e.contentUTF8());
    }
}
