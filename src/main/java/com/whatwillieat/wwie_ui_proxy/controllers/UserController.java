package com.whatwillieat.wwie_ui_proxy.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${app.API_V1_BASE_URL}/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<Object> me() {
        return ResponseEntity.ok(userService.getUser());
    }

    @PutMapping("/me")
    public ResponseEntity<Object> updateMe(@RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(userService.updateMe(rawRequest));
    }

    @GetMapping
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{userId}/role")
    public ResponseEntity<Object> updateUserRole(@PathVariable UUID userId, @RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(userService.updateUserRole(userId, rawRequest));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID userId) {
        userService.deleteUserByAdmin(userId);
        return ResponseEntity.ok().build();
    }

}
