package dev.lucasliet.todoey_rest.resource;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lucasliet.todoey_rest.model.User;
import dev.lucasliet.todoey_rest.repository.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/login")
public class LoginResource implements Serializable{
	
	private static final long serialVersionUID = -2550185165626007488L;
	
	@Autowired
	private Users users;
	
	@Value("${jwt.secret}")
	private String secret;
	
	@PostMapping
	@SuppressWarnings("serial")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		User isValid = users.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (isValid == null) return ResponseEntity.notFound().build();
		
		String token = 
			Jwts.builder()
				.addClaims(new HashMap<String, Object>() {{ put("id", user.getId()); }})
				.setSubject(user.getEmail())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 3000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
		
		Map<String, Object> response = new HashMap<String, Object>() {{ 
			put("auth", true);
			put("userId", user.getId());
			put("token", token);
		}};
		
		return ResponseEntity.ok(response);
	}
	
}