package dev.lucasliet.todoeyrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lucasliet.todoeyrest.model.UserLogin;

public interface Users extends JpaRepository<UserLogin, Long> {

}
