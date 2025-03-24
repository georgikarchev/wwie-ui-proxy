package com.whatwillieat.wwie_ui_proxy.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SecurityUtil {
    public static UUID getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof String userIdStr) {
            return UUID.fromString(userIdStr);
        }

        throw new IllegalStateException("User not authenticated");
    }
}

