package rva.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rva.model.TuristickaAgencija;
import rva.service.TuristickaAgencijaService;

@CrossOrigin
@RestController
@RequestMapping("turistickaAgencija")
public class TuristickaAgencijaController {
	
	@Autowired
	private TuristickaAgencijaService service;

	@GetMapping
	public ResponseEntity<List<TuristickaAgencija>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable long id) {
		if(service.existsById(id))
			return ResponseEntity.ok(service.getById(id));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Agencija was not found");
	}
	
	@PostMapping
	public ResponseEntity<?> post(@RequestBody TuristickaAgencija agencija) {
		return ResponseEntity.ok(service.create(agencija));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable long id, @RequestBody TuristickaAgencija agencija) {
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.update(agencija));
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Agencija was not found");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Agencija was not found");
	}

}
