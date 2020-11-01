package dev.lucasliet.todoeyrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lucasliet.todoeyrest.model.Contato;

public interface Contatos extends JpaRepository<Contato, Long> {

}
