package dev.lucasliet.todoey_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class TodoeyApiApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "<main style=\"display:flex; flex-direction:column; justify-content: center; align-items:center; height:100vh; font-family:sans-serif;\">"
      		+ "		<h1 style=\"margin-bottom:1rem\">Todoey REST API made with Springboot</h1>"
            + "     <h2 style=\"margin-bottom:.5rem\">Routes:</h2>"
      		+ "		<h3 style=\"display:flex; justify-content: space-around; width:50vw;\">"
      		+ "			<a style=\"color:#333\" href=\"https://todoey-rest-spring.herokuapp.com/users\">Users</a>"
      		+ "			<a style=\"color:#333\" href=\"https://todoey-rest-spring.herokuapp.com/reminders\">Reminders</a>"
      		+ "		</h3>"
      		+ "</main>";
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoeyApiApplication.class, args);
    }
}