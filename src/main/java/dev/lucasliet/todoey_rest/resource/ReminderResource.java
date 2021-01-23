package dev.lucasliet.todoey_rest.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lucasliet.todoey_rest.model.Reminder;
import dev.lucasliet.todoey_rest.repository.Reminders;

@RestController
@RequestMapping("/reminders")
public class ReminderResource {
	
	@Autowired
	private Reminders reminders;
	
	@PostMapping
	public Reminder save(@Valid @RequestBody Reminder reminder) {
		return reminders.save(reminder);
	}
	
	@GetMapping
	public ResponseEntity<List<Reminder>> list(@RequestHeader("user-id") Long userId) {
		if (userId == null) return ResponseEntity.ok(reminders.findAll());
		return ResponseEntity.ok(reminders.findAllByUserId(userId));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reminder> find(@PathVariable Long id) {
		Reminder reminder = reminders.getOne(id);
		
		return reminder == null
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(reminder);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Reminder> update(@PathVariable Long id, 
			@Valid @RequestBody Reminder reminder) {
		Reminder existent = reminders.getOne(id);
		
		if (existent == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(reminder, existent, "id");
		
		existent = reminders.save(existent);
		
		return ResponseEntity.ok(existent);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Reminder reminder = reminders.getOne(id);
		
		if (reminder == null) {
			return ResponseEntity.notFound().build();
		}
		
		reminders.delete(reminder);
		
		return ResponseEntity.noContent().build();
	}
}