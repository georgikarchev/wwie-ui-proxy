package com.whatwillieat.wwie_ui_proxy.clients;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "shopping-lists-service", url = "${app.shopping-lists.url}/shopping-lists")
public interface ShoppingListsClient {

    @GetMapping("/home")
    ResponseEntity<String> home(@RequestHeader("X-API-KEY") String apiKey);

    // Shopping Lists
    @GetMapping("/{shoppingListId}")
    ResponseEntity<Object> findShoppingList(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID shoppingListId);

    @GetMapping("/owners/{ownerId}")
    ResponseEntity<Object> findShoppingListsByOwner(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID ownerId);

    @PostMapping
    ResponseEntity<Object> createShoppingList(@RequestHeader("X-API-KEY") String apiKey, @RequestBody ObjectNode rawRequest);

    @PutMapping("/{shoppingListId}")
    ResponseEntity<Object> updateShoppingList(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID shoppingListId, @RequestBody ObjectNode rawRequest);

    @DeleteMapping("/{shoppingListId}")
    ResponseEntity<Object> deleteShoppingList(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID shoppingListId);

    @DeleteMapping("/owners/{ownerId}")
    ResponseEntity<Object> deleteShoppingListByOwner(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID ownerId);

    @PutMapping("/{shoppingListId}/undo-delete")
    ResponseEntity<Object> undoDeleteShoppingList(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID shoppingListId);

    // Shopping List Items
    @PostMapping("/{shoppingListId}/items")
    ResponseEntity<Object> createShoppingListItem(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID shoppingListId, @RequestBody ObjectNode rawRequest);

    @DeleteMapping("/{shoppingListId}/items/{shoppingListItemId}")
    ResponseEntity<Object> deleteShoppingListItem(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID shoppingListId, @PathVariable UUID shoppingListItemId);

    @PutMapping("/{shoppingListId}/items/{shoppingListItemId}/undo-delete")
    ResponseEntity<Object> undoDeleteShoppingListItem(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID shoppingListId, @PathVariable UUID shoppingListItemId);

    @PutMapping("/{shoppingListId}/items/{shoppingListItemId}")
    ResponseEntity<Object> updateShoppingListItem(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID shoppingListId, @PathVariable UUID shoppingListItemId, @RequestBody ObjectNode rawRequest);

    @PutMapping("/{shoppingListId}/items/{shoppingListItemId}/check")
    ResponseEntity<Object> checkShoppingListItem(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID shoppingListId, @PathVariable UUID shoppingListItemId);

    @PutMapping("/{shoppingListId}/items/{shoppingListItemId}/uncheck")
    ResponseEntity<Object> uncheckShoppingListItem(@RequestHeader("X-API-KEY") String apiKey, @PathVariable UUID shoppingListId, @PathVariable UUID shoppingListItemId);
}