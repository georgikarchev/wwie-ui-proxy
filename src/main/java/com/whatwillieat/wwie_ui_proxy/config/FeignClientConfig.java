package com.whatwillieat.wwie_ui_proxy.config;

import com.whatwillieat.wwie_ui_proxy.exception.CustomFeignErrorDecoder;
import com.whatwillieat.wwie_ui_proxy.exception.ForwardingErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // Logs request & response body, headers, etc.
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ForwardingErrorDecoder();
    }

//    @Bean
//    public ErrorDecoder errorDecoder() {
//        return new CustomFeignErrorDecoder();
//    }
}

