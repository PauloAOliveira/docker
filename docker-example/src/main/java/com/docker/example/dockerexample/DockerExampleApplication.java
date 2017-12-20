package com.docker.example.dockerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication
public class DockerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerExampleApplication.class, args);
	}
}

@RestController
class Controller {

	private final Logger LOGGER = Logger.getLogger("Controller");

	@GetMapping
	public String hello() {
		LOGGER.info("Hello from log");
		return "Hello World";
	}
}
