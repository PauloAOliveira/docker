package com.docker.example.dockerexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class DockerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerExampleApplication.class, args);
	}
}

@Document(collection = "example")
class Domain {

	@Id
	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

interface DomainRepository extends MongoRepository<Domain, String> {

}

@RestController
class Controller {

	private final Logger LOGGER = Logger.getLogger("Controller");

	@Autowired
	private DomainRepository domainRepository;

	@PostMapping(value = "/domain")
	public ResponseEntity<Domain> create(@RequestBody Domain domain) {
		Domain saved = domainRepository.save(domain);
		return ResponseEntity.ok(saved);
	}

	@GetMapping(value = "/domain/{id}")
	public ResponseEntity<Domain> getById(@PathVariable String id) {
		Domain domain = domainRepository.findOne(id);

		if(domain == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(domain);
		}
	}

	@GetMapping(value = "/domain")
	public ResponseEntity<List<Domain>> getAll() {
		List<Domain> domains = domainRepository.findAll();
		return ResponseEntity.ok(domains);
	}
}
