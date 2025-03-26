package com.whatwillieat.wwie_ui_proxy.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${app.API_V1_BASE_URL}/meals")
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;


    @GetMapping
    public ResponseEntity<Object> findMeals() {
        return ResponseEntity.ok(mealService.findMeals());
    }

    @GetMapping("/{mealId}")
    public ResponseEntity<Object> findMeal(@PathVariable UUID mealId) {
        return ResponseEntity.ok(mealService.findMeal(mealId));
    }

    @PutMapping("/{mealId}")
    public ResponseEntity<Object> updateMeal(@PathVariable UUID mealId, @RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(mealService.updateMeal(mealId,rawRequest));
    }

    @PostMapping
    public ResponseEntity<Object> createMeal(@RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(mealService.createMeal(rawRequest));
    }

    @DeleteMapping("/{mealId}")
    public ResponseEntity<Object> deleteMeal(@PathVariable UUID mealId) {
        return ResponseEntity.ok(mealService.deleteMeal(mealId));
    }

    @PostMapping("/{mealId}/ingredients")
    public ResponseEntity<Object> addIngredientToMeal(@PathVariable UUID mealId, @RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(mealService.addIngredientToMeal(mealId,rawRequest));
    }
}
