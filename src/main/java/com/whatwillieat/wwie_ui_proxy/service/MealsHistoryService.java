package com.whatwillieat.wwie_ui_proxy.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.clients.MealClient;
import com.whatwillieat.wwie_ui_proxy.clients.MealsHistoryClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MealsHistoryService {
    private final MealsHistoryClient mealsHistoryClient;

    @Value("${app.meals-history.api-key}")
    private String apiKey;

    public Object addMealToHistory(ObjectNode rawRequest) {
        log.info("Calling meals-history service for findMealsHistory...");
        ResponseEntity<Object> response = mealsHistoryClient.addMealToHistory(apiKey, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object findRecentMeals(UUID userId, String startDate) {
        log.info("Calling meals-history service for findRecentMeals...");
        ResponseEntity<Object> response = mealsHistoryClient.findRecentMeals(apiKey, userId, startDate);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object updateIngredient(UUID mealHistoryId, ObjectNode rawRequest) {
        log.info("Calling meals-history service for updateMealHistoryRating...");
        ResponseEntity<Object> response = mealsHistoryClient.updateMealHistoryRating(apiKey, mealHistoryId, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }
}
