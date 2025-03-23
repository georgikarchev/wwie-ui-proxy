package com.whatwillieat.wwie_ui_proxy.controllers;

import com.whatwillieat.wwie_ui_proxy.dto.UserLoginRequest;
import com.whatwillieat.wwie_ui_proxy.dto.UserRegistrationRequest;
import com.whatwillieat.wwie_ui_proxy.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.API_V1_BASE_URL}/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(usersService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(usersService.register(request));
    }
}
