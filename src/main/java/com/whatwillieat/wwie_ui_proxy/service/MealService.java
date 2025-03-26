package com.whatwillieat.wwie_ui_proxy.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.clients.MealClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MealService {
    private final MealClient mealClient;

    @Value("${app.meals.api-key}")
    private String apiKey;

    public Object findMeals() {
        log.info("Calling meals service for getMeals...");
        ResponseEntity<Object> response = mealClient.findMeals(apiKey);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object findMeal(UUID mealId) {
        log.info("Calling meals service for getMeals...");
        ResponseEntity<Object> response = mealClient.findMeal(apiKey, mealId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object updateMeal(UUID mealId, ObjectNode rawRequest) {
        log.info("Calling meals service for updateMeal...");
        ResponseEntity<Object> response = mealClient.updateMeal(apiKey, mealId, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object createMeal(ObjectNode rawRequest) {
        log.info("Calling meals service for createMeal...");
        ResponseEntity<Object> response = mealClient.createMeal(apiKey, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object deleteMeal(UUID mealId) {
        log.info("Calling meals service for deleteMeal...");
        ResponseEntity<Object> response = mealClient.deleteMeal(apiKey, mealId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }
}
