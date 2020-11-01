package dev.lucasliet.todoey_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lucasliet.todoey_rest.model.User;

public interface Users extends JpaRepository<User, Long> {

}
