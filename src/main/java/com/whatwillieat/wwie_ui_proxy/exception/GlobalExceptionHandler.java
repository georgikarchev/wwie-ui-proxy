package com.whatwillieat.wwie_ui_proxy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleFeignError(Exception ex) {
        // Assuming the error message contains the status code and body
        String errorMessage = ex.getMessage();

        // Parse the status code and body from the exception message (you might need to adjust this)
        int statusCode = extractStatusCode(errorMessage);
        String responseBody = extractResponseBody(errorMessage);

        // Return the forwarded response with the status code and body
        return new ResponseEntity<>(responseBody, HttpStatus.valueOf(statusCode));
    }

    private int extractStatusCode(String errorMessage) {
        // Extract the status code from the error message
        // (You can adjust this based on how the error message is structured)
        return Integer.parseInt(errorMessage.split(" ")[1]);
    }

    private String extractResponseBody(String errorMessage) {
        // Extract the body (you can adjust this based on your needs)
        return errorMessage.split(" - ")[1];
    }
}
