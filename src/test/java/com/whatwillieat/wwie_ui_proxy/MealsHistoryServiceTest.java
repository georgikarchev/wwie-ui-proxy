package com.whatwillieat.wwie_ui_proxy;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.whatwillieat.wwie_ui_proxy.clients.MealsHistoryClient;
import com.whatwillieat.wwie_ui_proxy.service.MealsHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MealsHistoryServiceTest {

    @Mock
    private MealsHistoryClient mealsHistoryClient;

    @InjectMocks
    private MealsHistoryService mealsHistoryService;

    private ObjectNode mockRequest;
    private ResponseEntity<Object> mockResponse;

    @BeforeEach
    void setUp() {
        mockRequest = Mockito.mock(ObjectNode.class);
        mockResponse = ResponseEntity.ok("mock response");
    }

    @Test
    void testAddMealToHistory() {
        // Given
        when(mealsHistoryClient.addMealToHistory(anyString(), eq(mockRequest)))
                .thenReturn(mockResponse);

        // When
        Object result = mealsHistoryService.addMealToHistory(mockRequest);

        // Then
        assertThat(result).isEqualTo(mockResponse.getBody());
        verify(mealsHistoryClient, times(1)).addMealToHistory(anyString(), eq(mockRequest));
    }

    @Test
    void testFindRecentMeals() {
        // Given
        UUID userId = UUID.randomUUID();
        String startDate = "2025-01-01";
        when(mealsHistoryClient.findRecentMeals(anyString(), eq(userId), eq(startDate)))
                .thenReturn(mockResponse);

        // When
        Object result = mealsHistoryService.findRecentMeals(userId, startDate);

        // Then
        assertThat(result).isEqualTo(mockResponse.getBody());
        verify(mealsHistoryClient, times(1)).findRecentMeals(anyString(), eq(userId), eq(startDate));
    }

    @Test
    void testUpdateIngredient() {
        // Given
        UUID mealHistoryId = UUID.randomUUID();
        when(mealsHistoryClient.updateMealHistoryRating(anyString(), eq(mealHistoryId), eq(mockRequest)))
                .thenReturn(mockResponse);

        // When
        Object result = mealsHistoryService.updateIngredient(mealHistoryId, mockRequest);

        // Then
        assertThat(result).isEqualTo(mockResponse.getBody());
        verify(mealsHistoryClient, times(1)).updateMealHistoryRating(anyString(), eq(mealHistoryId), eq(mockRequest));
    }
}

