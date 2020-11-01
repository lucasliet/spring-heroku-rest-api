package dev.lucasliet.todoey_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class TodoeyApiApplication {
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
      return "Spring Heroku REST api test";
    }

	public static void main(String[] args) {
		SpringApplication.run(TodoeyApiApplication.class, args);
	}
}
