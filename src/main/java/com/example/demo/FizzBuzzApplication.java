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

	@GetMapping("/FizzBuzz") // mapping to the fizzbuzz function
	public ObjectNode hello(@RequestParam(value = "eingabe", defaultValue = "225") Integer eingabe) {
		// creating the json object
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode ausgabe = mapper.createObjectNode();

		// iterating through the numbers up to the param eingabe
		for (int i = 1; i <= eingabe; i++) {
			String tmp = "";
			if (i % 3 == 0) {
				tmp = "Fizz"; // if i dividable by 3 add 'fizz' to tmp
			}
			if (i % 5 == 0) {
				tmp += "Buzz"; // if i dividable by 5 add 'buzz' to tmp
			}
			ausgabe.put(String.valueOf(i), tmp); // add the number and the result stored in tmp to the json object
													// ausgabe
		}
		return ausgabe; // return the json object
	}

}
