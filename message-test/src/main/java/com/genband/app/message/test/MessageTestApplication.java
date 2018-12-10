package com.genband.app.message.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.genband.app.message.test, com.cpaas.portal")
public class MessageTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageTestApplication.class, args);
	}
}
