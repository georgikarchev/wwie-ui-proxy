package com.whatwillieat.wwie_ui_proxy;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.clients.MealClient;
import com.whatwillieat.wwie_ui_proxy.service.MealService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MealServiceTest {

    @Mock
    private MealClient mealClient;

    @InjectMocks
    private MealService mealService;

    private UUID mealId;
    private ObjectNode rawRequest;
    private ResponseEntity<Object> responseEntity;

    @BeforeEach
    void setUp() {
        mealId = UUID.randomUUID();
        rawRequest = Mockito.mock(ObjectNode.class);  // Mock ObjectNode
        responseEntity = ResponseEntity.ok().build(); // Mock a response
    }

    @Test
    void findMeals_shouldCallMealClientAndReturnResponse() {
        // Arrange
        when(mealClient.findMeals(Mockito.anyString())).thenReturn(responseEntity);

        // Act
        Object result = mealService.findMeals();

        // Assert
        assertEquals(responseEntity.getBody(), result);
        verify(mealClient).findMeals(Mockito.anyString());
    }

//    @Test
//    void findMeal_shouldCallMealClientAndReturnResponse() {
//        // Arrange
//        when(mealClient.findMeal(Mockito.anyString(), Mockito.any(UUID.class))).thenReturn(responseEntity);
//
//        // Act
//        Object result = mealService.findMeal(mealId);
//
//        // Assert
//        assertEquals(responseEntity.getBody(), result);
//        verify(mealClient).findMeal(Mockito.anyString(), Mockito.any(UUID.class));
//    }
//
//    @Test
//    void updateMeal_shouldCallMealClientAndReturnResponse() {
//        // Arrange
//        when(mealClient.updateMeal(Mockito.anyString(), Mockito.any(UUID.class), Mockito.any(ObjectNode.class))).thenReturn(responseEntity);
//
//        // Act
//        Object result = mealService.updateMeal(mealId, rawRequest);
//
//        // Assert
//        assertEquals(responseEntity.getBody(), result);
//        verify(mealClient).updateMeal(Mockito.anyString(), Mockito.any(UUID.class), Mockito.any(ObjectNode.class));
//    }
//
//    @Test
//    void createMeal_shouldCallMealClientAndReturnResponse() {
//        // Arrange
//        when(mealClient.createMeal(Mockito.anyString(), Mockito.any(ObjectNode.class))).thenReturn(responseEntity);
//
//        // Act
//        Object result = mealService.createMeal(rawRequest);
//
//        // Assert
//        assertEquals(responseEntity.getBody(), result);
//        verify(mealClient).createMeal(Mockito.anyString(), Mockito.any(ObjectNode.class));
//    }
//
//    @Test
//    void deleteMeal_shouldCallMealClientAndReturnResponse() {
//        // Arrange
//        when(mealClient.deleteMeal(Mockito.anyString(), Mockito.any(UUID.class))).thenReturn(responseEntity);
//
//        // Act
//        Object result = mealService.deleteMeal(mealId);
//
//        // Assert
//        assertEquals(responseEntity.getBody(), result);
//        verify(mealClient).deleteMeal(Mockito.anyString(), Mockito.any(UUID.class));
//    }
//
//    @Test
//    void addIngredientToMeal_shouldCallMealClientAndReturnResponse() {
//        // Arrange
//        when(mealClient.addIngredientToMeal(Mockito.anyString(), Mockito.any(UUID.class), Mockito.any(ObjectNode.class)))
//                .thenReturn(responseEntity);
//
//        // Act
//        Object result = mealService.addIngredientToMeal(mealId, rawRequest);
//
//        // Assert
//        assertEquals(responseEntity.getBody(), result);
//        verify(mealClient).addIngredientToMeal(Mockito.anyString(), Mockito.any(UUID.class), Mockito.any(ObjectNode.class));
//    }
}

