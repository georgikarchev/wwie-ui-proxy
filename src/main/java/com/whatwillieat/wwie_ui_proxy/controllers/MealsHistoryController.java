package com.whatwillieat.wwie_ui_proxy.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.service.MealService;
import com.whatwillieat.wwie_ui_proxy.service.MealsHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${app.API_V1_BASE_URL}/meals-history")
@RequiredArgsConstructor
public class MealsHistoryController {
    private final MealsHistoryService mealsHistoryService;


    @PostMapping
    public ResponseEntity<Object> addMealToHistory(@RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(mealsHistoryService.addMealToHistory(rawRequest));
    }

    @GetMapping("/recent")
    public ResponseEntity<Object> findMeal(@RequestParam UUID userId, @RequestParam String startDate) {
        return ResponseEntity.ok(mealsHistoryService.findRecentMeals(userId, startDate));
    }

    @PutMapping("/{mealHistoryId}/rating")
    public ResponseEntity<Object> updateMeal(@PathVariable UUID mealHistoryId, @RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(mealsHistoryService.updateIngredient(mealHistoryId,rawRequest));
    }
}
