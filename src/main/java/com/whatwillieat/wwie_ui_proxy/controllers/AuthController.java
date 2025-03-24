package com.whatwillieat.wwie_ui_proxy.controllers;

import com.whatwillieat.wwie_ui_proxy.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.API_V1_BASE_URL}/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String request) {
        return ResponseEntity.ok(usersService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody String request) {
        return ResponseEntity.ok(usersService.register(request));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("all is good - test endpoint here");
    }
}
