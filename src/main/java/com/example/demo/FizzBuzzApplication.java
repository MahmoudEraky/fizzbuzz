package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
public class FizzBuzzApplication {

	public static void main(String[] args) {
		SpringApplication.run(FizzBuzzApplication.class, args);
	}

	@GetMapping("/FizzBuzz")
	public ObjectNode hello(@RequestParam(value = "eingabe", defaultValue = "225") Integer eingabe) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode ausgabe = mapper.createObjectNode();
		for (int i = 1; i <= eingabe; i++) {
			String tmp = "";
			if (i % 3 == 0) {
				tmp = "Fizz";
			}
			if (i % 5 == 0) {
				tmp += "Buzz";
			}
			ausgabe.put(String.valueOf(i), tmp);
		}
		return ausgabe;
	}

}
