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
public class IngredientService {
    private final MealClient mealClient;

    @Value("${app.meals.api-key}")
    private String apiKey;

    public Object findIngredients() {
        log.info("Calling meals service for getIngredients...");
        ResponseEntity<Object> response = mealClient.findIngredients(apiKey);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object findIngredient(UUID ingredientId) {
        log.info("Calling meals service for getIngredient...");
        ResponseEntity<Object> response = mealClient.findIngredient(apiKey, ingredientId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object updateIngredient(UUID ingredientId, ObjectNode rawRequest) {
        log.info("Calling meals service for updateIngredient...");
        ResponseEntity<Object> response = mealClient.updateIngredient(apiKey, ingredientId, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object createIngredient(ObjectNode rawRequest) {
        log.info("Calling meals service for createIngredient...");
        ResponseEntity<Object> response = mealClient.createIngredient(apiKey, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object deleteIngredient(UUID ingredientId) {
        log.info("Calling meals service for deleteIngredient...");
        ResponseEntity<Object> response = mealClient.deleteIngredient(apiKey, ingredientId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }
}
