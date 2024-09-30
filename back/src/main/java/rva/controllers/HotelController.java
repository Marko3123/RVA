package rva.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rva.model.Destinacija;
import rva.model.Hotel;
import rva.service.DestinacijaService;
import rva.service.HotelService;

@CrossOrigin
@RestController
@RequestMapping("hotel")
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@Autowired
	private DestinacijaService destinacijaService;
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable long id) {
		if(service.getById(id).isPresent())
			return ResponseEntity.ok(service.getById(id).get());
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hotel was not found");
	}

	@GetMapping("/destinacija/{id}")
	public ResponseEntity<?> getByDestinacija(@PathVariable long id) {
		Optional<Destinacija> destinacija = destinacijaService.getById(id);
		if(destinacija.isPresent()) {
			List<Hotel> list = service.getByDestinacija(destinacija.get());
			return ResponseEntity.ok(list);
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hotel was not found");
	}
	
	@PostMapping
	public ResponseEntity<Hotel> post(@RequestBody Hotel hotel) {
		return ResponseEntity.ok(service.create(hotel));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put(@RequestBody Hotel hotel, @PathVariable long id) {
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.update(hotel));
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hotel was not found");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hotel was not found");
	}

}