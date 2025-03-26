package com.whatwillieat.wwie_ui_proxy.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.service.IngredientService;
import com.whatwillieat.wwie_ui_proxy.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${app.API_V1_BASE_URL}/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;


    @GetMapping
    public ResponseEntity<Object> findIngredients() {
        return ResponseEntity.ok(ingredientService.findIngredients());
    }

    @GetMapping("/{ingredientId}")
    public ResponseEntity<Object> findIngredient(@PathVariable UUID ingredientId) {
        return ResponseEntity.ok(ingredientService.findIngredient(ingredientId));
    }

    @PutMapping("/{ingredientId}")
    public ResponseEntity<Object> updateIngredient(@PathVariable UUID ingredientId, @RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(ingredientService.updateIngredient(ingredientId,rawRequest));
    }

    @PostMapping
    public ResponseEntity<Object> createIngredient(@RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(ingredientService.createIngredient(rawRequest));
    }

    @DeleteMapping("/{ingredientId}")
    public ResponseEntity<Object> deleteIngredient(@PathVariable UUID ingredientId) {
        return ResponseEntity.ok(ingredientService.deleteIngredient(ingredientId));
    }
}
