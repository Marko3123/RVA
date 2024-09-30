package rva.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rva.model.Aranzman;
import rva.model.Hotel;
import rva.model.TuristickaAgencija;
import rva.service.AranzmanService;
import rva.service.HotelService;
import rva.service.TuristickaAgencijaService;

@CrossOrigin
@RestController
@RequestMapping("aranzman")
public class AranzmanController {
	
	@Autowired
	private AranzmanService service;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private TuristickaAgencijaService agencijaService;
	
	@GetMapping
	public ResponseEntity<List<Aranzman>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable long id) {
		if(service.getById(id).isPresent())
			return ResponseEntity.ok(service.getById(id).get());
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aranzman was not found");
	}

	@GetMapping("/hotel/{id}")
	public ResponseEntity<?> getByHotel(@PathVariable long id) {
		Optional<Hotel> hotel = hotelService.getById(id);
		if(hotel.isPresent()) {
			List<Aranzman> list = service.getByHotel(hotel.get());
			return ResponseEntity.ok(list);
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aranzman was not found");
	}

	@GetMapping("/agencija/{id}")
	public ResponseEntity<?> getByAgencija(@PathVariable long id) {
		Optional<TuristickaAgencija> agencija = agencijaService.getById(id);
		if(agencija.isPresent()) {
			List<Aranzman> list = service.getByAgencija(agencija.get());
			return ResponseEntity.ok(list);
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aranzman was not found");
	}
	
	@PostMapping
	public ResponseEntity<Aranzman> post(@RequestBody Aranzman aranzman) {
		return ResponseEntity.ok(service.create(aranzman));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable long id, @RequestBody Aranzman aranzman) {
		if(service.existsById(id)) {
			aranzman.setId(id);
			Aranzman savedAranzman = service.update(aranzman);
			return ResponseEntity.ok(savedAranzman);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aranzman was not found");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		if(service.existsById(id)) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aranzman was not found");
	}

}
