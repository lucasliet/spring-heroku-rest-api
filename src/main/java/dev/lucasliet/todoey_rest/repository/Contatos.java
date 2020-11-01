package dev.lucasliet.todoey_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lucasliet.todoey_rest.model.Contato;

public interface Contatos extends JpaRepository<Contato, Long> {

}
