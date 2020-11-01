package dev.lucasliet.todoey_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lucasliet.todoey_rest.model.Reminder;

public interface Reminders extends JpaRepository<Reminder, Long> {

}
