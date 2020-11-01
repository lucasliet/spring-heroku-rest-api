package dev.lucasliet.todoeyrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lucasliet.todoeyrest.model.Reminder;

public interface Reminders extends JpaRepository<Reminder, Long> {

}
