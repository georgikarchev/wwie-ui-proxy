package com.whatwillieat.wwie_ui_proxy.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.clients.ShoppingListsClient;
import com.whatwillieat.wwie_ui_proxy.service.MealsHistoryService;
import com.whatwillieat.wwie_ui_proxy.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${app.API_V1_BASE_URL}/shopping-lists")
@RequiredArgsConstructor
public class ShoppingListsController {
    private final ShoppingListService shoppingListService;


    // Shopping Lists
    @GetMapping("/home")
    public ResponseEntity<String> findMeal() {
        return ResponseEntity.ok(shoppingListService.getHome());
    }

    @PostMapping
    public ResponseEntity<Object> createShoppingList(@RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(shoppingListService.createShoppingList(rawRequest));
    }

    @GetMapping("/{shoppingListId}")
    public ResponseEntity<Object> findShoppingList(@PathVariable UUID shoppingListId) {
        return ResponseEntity.ok(shoppingListService.findShoppingList(shoppingListId));
    }

    @GetMapping("/owners/{ownerId}")
    public ResponseEntity<Object> findShoppingListsByOwner(@PathVariable UUID ownerId) {
        return ResponseEntity.ok(shoppingListService.findShoppingListsByOwner(ownerId));
    }

    @PutMapping("/{shoppingListId}")
    public ResponseEntity<Object> updateShoppingList(@PathVariable UUID shoppingListId, @RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(shoppingListService.updateShoppingList(shoppingListId, rawRequest));
    }

    @DeleteMapping("/{shoppingListId}")
    public ResponseEntity<Object> deleteShoppingList(@PathVariable UUID shoppingListId) {
        shoppingListService.deleteShoppingList(shoppingListId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/owners/{ownerId}")
    public ResponseEntity<Object> deleteShoppingListByOwner(@PathVariable UUID ownerId) {
        shoppingListService.deleteShoppingListByOwner(ownerId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{shoppingListId}/undo-delete")
    public ResponseEntity<Object> updateShoppingList(@PathVariable UUID shoppingListId) {
        return ResponseEntity.ok(shoppingListService.undoDeleteShoppingList(shoppingListId));
    }

    // Shopping List Items
    @PostMapping("/{shoppingListId}/items")
    public ResponseEntity<Object> createShoppingListItem(@PathVariable UUID shoppingListId, @RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(shoppingListService.createShoppingListItem(shoppingListId, rawRequest));
    }

    @DeleteMapping("/{shoppingListId}/items/{shoppingListItemId}")
    public ResponseEntity<Void> deleteShoppingListItem(@PathVariable UUID shoppingListId, @PathVariable UUID shoppingListItemId) {
        shoppingListService.deleteShoppingListItem(shoppingListId, shoppingListItemId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{shoppingListId}/items/{shoppingListItemId}/undo-delete")
    public ResponseEntity<Void> undoDeleteShoppingListItem(@PathVariable UUID shoppingListId, @PathVariable UUID shoppingListItemId) {
        shoppingListService.undoDeleteShoppingListItem(shoppingListId, shoppingListItemId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{shoppingListId}/items/{shoppingListItemId}")
    public ResponseEntity<Object> updateShoppingListItem(@PathVariable UUID shoppingListId, @PathVariable UUID shoppingListItemId, @RequestBody ObjectNode rawRequest) {
        return ResponseEntity.ok(shoppingListService.updateShoppingListItem(shoppingListId, shoppingListItemId, rawRequest));
    }

    @PutMapping("/{shoppingListId}/items/{shoppingListItemId}/check")
    public ResponseEntity<Object> checkShoppingListItem(@PathVariable UUID shoppingListId, @PathVariable UUID shoppingListItemId) {
        return ResponseEntity.ok(shoppingListService.checkShoppingListItem(shoppingListId, shoppingListItemId));
    }

    @PutMapping("/{shoppingListId}/items/{shoppingListItemId}/uncheck")
    public ResponseEntity<Object> uncheckShoppingListItem(@PathVariable UUID shoppingListId, @PathVariable UUID shoppingListItemId) {
        return ResponseEntity.ok(shoppingListService.uncheckShoppingListItem(shoppingListId, shoppingListItemId));
    }
}
