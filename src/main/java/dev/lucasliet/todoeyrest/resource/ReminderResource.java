package dev.lucasliet.todoeyrest.resource;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lucasliet.todoeyrest.model.Contato;
import dev.lucasliet.todoeyrest.model.Reminder;
import dev.lucasliet.todoeyrest.repository.Reminders;

@RestController
@RequestMapping("/reminders")
public class ReminderResource {
	
	@Autowired
	private Reminders reminders;
	
	@PostMapping
	public Reminder adicionar(@Valid @RequestBody Reminder reminder) {
		return reminders.save(reminder);
	}
	
	@GetMapping
	public List<Reminder> listar() {
		return reminders.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reminder> buscar(@PathVariable Long id) {
		Reminder reminder = reminders.getOne(id);
		
		if (reminder == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(reminder);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Reminder> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Contato contato) {
		Reminder existente = reminders.getOne(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(contato, existente, "id");
		
		existente = reminders.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Reminder reminder = reminders.getOne(id);
		
		if (reminder == null) {
			return ResponseEntity.notFound().build();
		}
		
		reminders.delete(reminder);
		
		return ResponseEntity.noContent().build();
	}
}