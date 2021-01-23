package dev.lucasliet.todoey_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.lucasliet.todoey_rest.model.User;

public interface Users extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
	public User findByEmailAndPassword(String email, String password);
	
}
