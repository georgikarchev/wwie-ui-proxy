package com.whatwillieat.wwie_ui_proxy.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.clients.MealsHistoryClient;
import com.whatwillieat.wwie_ui_proxy.clients.ShoppingListsClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShoppingListService {
    private final ShoppingListsClient shoppingListsClient;

    @Value("${app.shopping-lists.api-key}")
    private String apiKey;


    // Shopping Lists
    public String getHome() {
        log.info("Calling shopping-lists service for home...");
        ResponseEntity<String> response = shoppingListsClient.home(apiKey);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object createShoppingList(ObjectNode rawRequest) {
        log.info("Calling shopping-lists service for createShoppingList...");
        ResponseEntity<Object> response = shoppingListsClient.createShoppingList(apiKey, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object findShoppingList(UUID shoppingListId) {
        log.info("Calling shopping-lists service for findShoppingList...");
        ResponseEntity<Object> response = shoppingListsClient.findShoppingList(apiKey, shoppingListId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object findShoppingListsByOwner(UUID ownerId) {
        log.info("Calling shopping-lists service for findShoppingListsByOwner...");
        ResponseEntity<Object> response = shoppingListsClient.findShoppingListsByOwner(apiKey, ownerId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object updateShoppingList(UUID shoppingListId, ObjectNode rawRequest) {
        log.info("Calling shopping-lists service for updateShoppingList...");
        ResponseEntity<Object> response = shoppingListsClient.updateShoppingList(apiKey, shoppingListId, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public void deleteShoppingList(UUID shoppingListId) {
        log.info("Calling shopping-lists service for deleteShoppingList...");
        shoppingListsClient.deleteShoppingList(apiKey, shoppingListId);
        log.info("Received response: {}", shoppingListId);
    }

    public void deleteShoppingListByOwner(UUID ownerId) {
        log.info("Calling shopping-lists service for deleteShoppingListByOwner...");
        shoppingListsClient.deleteShoppingListByOwner(apiKey, ownerId);
        log.info("Received response: {}", ownerId);
    }

    public Object undoDeleteShoppingList(UUID shoppingListId) {
        log.info("Calling shopping-lists service for undoDeleteShoppingList...");
        ResponseEntity<Object> response = shoppingListsClient.undoDeleteShoppingList(apiKey, shoppingListId);
        log.info("Received response: {}", shoppingListId);
        return response.getBody();
    }

    // Shopping List Items
    public Object createShoppingListItem(UUID shoppingListId, ObjectNode rawRequest) {
        log.info("Calling shopping-lists service for createShoppingListItem...");
        ResponseEntity<Object> response = shoppingListsClient.createShoppingListItem(apiKey, shoppingListId, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public void deleteShoppingListItem(UUID shoppingListId, UUID shoppingListItemId) {
        log.info("Calling shopping-lists service for deleteShoppingListByOwner...");
        shoppingListsClient.deleteShoppingListItem(apiKey, shoppingListId, shoppingListItemId);
        log.info("Received response: {}");
    }

    public Object undoDeleteShoppingListItem(UUID shoppingListId, UUID shoppingListItemId) {
        log.info("Calling shopping-lists service for undoDeleteShoppingListId...");
        ResponseEntity<Object> response = shoppingListsClient.undoDeleteShoppingListItem(apiKey, shoppingListId, shoppingListItemId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object updateShoppingListItem(UUID shoppingListId, UUID shoppingListItemId, ObjectNode rawRequest) {
        log.info("Calling shopping-lists service for updateShoppingList...");
        ResponseEntity<Object> response = shoppingListsClient.updateShoppingListItem(apiKey, shoppingListId, shoppingListItemId, rawRequest);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object checkShoppingListItem(UUID shoppingListId, UUID shoppingListItemId) {
        log.info("Calling shopping-lists service for checkShoppingList...");
        ResponseEntity<Object> response = shoppingListsClient.checkShoppingListItem(apiKey, shoppingListId, shoppingListItemId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

    public Object uncheckShoppingListItem(UUID shoppingListId, UUID shoppingListItemId) {
        log.info("Calling shopping-lists service for uncheckShoppingList...");
        ResponseEntity<Object> response = shoppingListsClient.uncheckShoppingListItem(apiKey, shoppingListId, shoppingListItemId);
        log.info("Received response: {}", response.getBody());
        return response.getBody();
    }

}
