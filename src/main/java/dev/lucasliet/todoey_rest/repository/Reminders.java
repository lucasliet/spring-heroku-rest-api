package dev.lucasliet.todoey_rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.lucasliet.todoey_rest.model.Reminder;

public interface Reminders extends JpaRepository<Reminder, Long> {
	@Query("SELECT * FROM reminders WHERE user_id = ?1")
	public List<Reminder> findAllByUserId(Long id);
}
