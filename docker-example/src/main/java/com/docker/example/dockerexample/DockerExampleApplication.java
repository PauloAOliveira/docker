package com.docker.example.dockerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DockerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerExampleApplication.class, args);
	}
}

@RestController
class Controller {

	@GetMapping
	public String hello() {
		return "Hello World";
	}
}
