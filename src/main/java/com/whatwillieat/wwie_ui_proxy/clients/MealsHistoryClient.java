package com.whatwillieat.wwie_ui_proxy.clients;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "meals-history-service", url = "${app.meals-history.url}/meals-history")
public interface MealsHistoryClient {

    @PostMapping
    ResponseEntity<Object> findMealsHistory(@RequestHeader("X-API-KEY") String apiKey, @RequestBody ObjectNode rawRequest);

    @GetMapping("/recent")
    ResponseEntity<Object> findRecentMeals(@RequestHeader("X-API-KEY") String apiKey, @RequestParam UUID userId, @RequestParam String startDate);

    @PutMapping("/{mealHistoryId}/rating")
    ResponseEntity<Object> updateMealHistoryRating(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID mealHistoryId, @RequestBody ObjectNode rawRequest);
}