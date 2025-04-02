package com.whatwillieat.wwie_ui_proxy.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;

public class ForwardingErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        // Simply return a generic exception, while still forwarding the response
        return new Exception("Forwarded error: " + response.status() + " - " + response.body().toString());
    }
}
