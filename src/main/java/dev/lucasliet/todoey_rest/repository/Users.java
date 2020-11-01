package dev.lucasliet.todoey_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lucasliet.todoey_rest.model.UserLogin;

public interface Users extends JpaRepository<UserLogin, Long> {

}
