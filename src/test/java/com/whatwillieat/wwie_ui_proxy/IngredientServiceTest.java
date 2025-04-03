package com.whatwillieat.wwie_ui_proxy;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.clients.MealClient;
import com.whatwillieat.wwie_ui_proxy.service.IngredientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IngredientServiceTest {

    @Mock
    private MealClient mealClient;

    @InjectMocks
    private IngredientService ingredientService;

    @BeforeEach
    public void setUp() {
        // You can mock any setup behavior here if needed.
    }

    @Test
    void testFindIngredients() {
        // Mock the response of the meal client
        ResponseEntity<Object> mockResponse = new ResponseEntity<>(new Object(), HttpStatus.OK);
        when(mealClient.findIngredients(any())).thenReturn(mockResponse);

        // Call the method
        Object result = ingredientService.findIngredients();

        // Verify interactions
        verify(mealClient).findIngredients(any());

        // Check if the result matches the expected response body
        assert result != null; // More specific assertions can be added based on expected content
    }

    @Test
    void testFindIngredient() {
        UUID ingredientId = UUID.randomUUID();
        ResponseEntity<Object> mockResponse = new ResponseEntity<>(new Object(), HttpStatus.OK);
        when(mealClient.findIngredient(any(), eq(ingredientId))).thenReturn(mockResponse);

        Object result = ingredientService.findIngredient(ingredientId);

        verify(mealClient).findIngredient(any(), eq(ingredientId));
        assert result != null;
    }

    @Test
    void testUpdateIngredient() {
        UUID ingredientId = UUID.randomUUID();
        ObjectNode rawRequest = mock(ObjectNode.class);
        ResponseEntity<Object> mockResponse = new ResponseEntity<>(new Object(), HttpStatus.OK);
        when(mealClient.updateIngredient(any(), eq(ingredientId), eq(rawRequest))).thenReturn(mockResponse);

        Object result = ingredientService.updateIngredient(ingredientId, rawRequest);

        verify(mealClient).updateIngredient(any(), eq(ingredientId), eq(rawRequest));
        assert result != null;
    }

    @Test
    void testCreateIngredient() {
        ObjectNode rawRequest = mock(ObjectNode.class);
        ResponseEntity<Object> mockResponse = new ResponseEntity<>(new Object(), HttpStatus.OK);
        when(mealClient.createIngredient(any(), eq(rawRequest))).thenReturn(mockResponse);

        Object result = ingredientService.createIngredient(rawRequest);

        verify(mealClient).createIngredient(any(), eq(rawRequest));
        assert result != null;
    }

    @Test
    void testDeleteIngredient() {
        UUID ingredientId = UUID.randomUUID();
        ResponseEntity<Object> mockResponse = new ResponseEntity<>(new Object(), HttpStatus.OK);
        when(mealClient.deleteIngredient(any(), eq(ingredientId))).thenReturn(mockResponse);

        Object result = ingredientService.deleteIngredient(ingredientId);

        verify(mealClient).deleteIngredient(any(), eq(ingredientId));
        assert result != null;
    }
}

