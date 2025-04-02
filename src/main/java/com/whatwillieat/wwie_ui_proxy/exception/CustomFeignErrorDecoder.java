package com.whatwillieat.wwie_ui_proxy.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomFeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == HttpStatus.BAD_REQUEST.value()) {
            return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or email already taken");
        }
        return new Default().decode(methodKey, response);
    }
}
