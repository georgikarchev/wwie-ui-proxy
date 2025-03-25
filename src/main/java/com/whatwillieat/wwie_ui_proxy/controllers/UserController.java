package com.whatwillieat.wwie_ui_proxy.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.service.UsersService;
import com.whatwillieat.wwie_ui_proxy.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${app.API_V1_BASE_URL}/users")
@RequiredArgsConstructor
public class UserController {
    private final UsersService usersService;

    @GetMapping("/me")
    public ResponseEntity<Object> me() {
        UUID userId = SecurityUtil.getAuthenticatedUserId();
        return ResponseEntity.ok(usersService.getUser(userId));
    }
}
