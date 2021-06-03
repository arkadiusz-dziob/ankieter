package com.ardz.ankieter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ardz.ankieter")
public class AnkieterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnkieterApplication.class, args);
	}

}
