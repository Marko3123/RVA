package rva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rva.model.Destinacija;
import rva.service.DestinacijaService;

@CrossOrigin
@RestController
@RequestMapping("destinacija")
public class DestinacijaController {
	
	@Autowired
	private DestinacijaService service;
	
	@GetMapping
	public ResponseEntity<List<Destinacija>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable long id) {
		if(service.existsById(id))
			return ResponseEntity.ok(service.getById(id));
		else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Destinacija was not found");
	}
	
	@PostMapping
	public ResponseEntity<Destinacija> post(@RequestBody Destinacija destinacija) {
		return ResponseEntity.ok(service.save(destinacija));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable long id, @RequestBody Destinacija destinacija) {
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.save(destinacija));
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Destinacija was not found");

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Destinacija was not found");
	}

}
