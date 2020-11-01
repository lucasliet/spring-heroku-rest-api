package dev.lucasliet.todoey_rest.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lucasliet.todoey_rest.model.User;
import dev.lucasliet.todoey_rest.repository.Users;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private Users users;
	
	@PostMapping
	public User save(@RequestBody User user) {
		return users.save(user);
	}
	
	@GetMapping
	public List<User> list(){
		return users.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> find(@PathVariable Long id){
		User user = users.getOne(id);
		
		return user == null 
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, 
			@Valid @RequestBody User user) {
		User existent = users.getOne(id);
		
		if (existent == null)
			return ResponseEntity.notFound().build();
		
		BeanUtils.copyProperties(user, existent, "id");
		
		existent = users.save(existent);
		
		return ResponseEntity.ok(existent);
	}
}