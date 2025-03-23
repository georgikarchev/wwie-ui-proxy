package com.whatwillieat.wwie_ui_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.whatwillieat.wwie_ui_proxy.clients")
@SpringBootApplication
public class WwieUiProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WwieUiProxyApplication.class, args);
	}

}
