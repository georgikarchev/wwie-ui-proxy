package com.whatwillieat.wwie_ui_proxy.clients;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "meals-service", url = "${app.meals.url}")
public interface MealClient {

    // Meals
    @GetMapping("/meals")
    ResponseEntity<Object> findMeals(@RequestHeader("X-API-KEY") String apiKey);

    @GetMapping("/meals/{mealId}")
    ResponseEntity<Object> findMeal(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID mealId);

    @PutMapping("/meals/{mealId}")
    ResponseEntity<Object> updateMeal(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID mealId, @RequestBody ObjectNode rawRequest);

    @PostMapping("/meals")
    ResponseEntity<Object> createMeal(@RequestHeader("X-API-KEY") String apiKey, @RequestBody ObjectNode rawRequest);

    @DeleteMapping("/meals/{mealId}")
    ResponseEntity<Object> deleteMeal(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID mealId);

    @PostMapping("/meals/{mealId}/ingredients")
    ResponseEntity<Object> addIngredientToMeal(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID mealId, @RequestBody ObjectNode rawRequest);

    // Ingredients
    @GetMapping("/ingredients")
    ResponseEntity<Object> findIngredients(@RequestHeader("X-API-KEY") String apiKey);

    @GetMapping("/ingredient/{ingredientId}")
    ResponseEntity<Object> findIngredient(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID ingredientId);

    @PutMapping("/ingredients/{ingredientId}")
    ResponseEntity<Object> updateIngredient(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID ingredientId, @RequestBody ObjectNode rawRequest);

    @PostMapping("/ingredients")
    ResponseEntity<Object> createIngredient(@RequestHeader("X-API-KEY") String apiKey, @RequestBody ObjectNode rawRequest);

    @DeleteMapping("/ingredients/{ingredientId}")
    ResponseEntity<Object> deleteIngredient(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID ingredientId);
}