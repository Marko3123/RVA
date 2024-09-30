package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Destinacija;
import rva.model.Hotel;
import rva.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository repository;

	public boolean existsById(long id) {
		return repository.existsById(id);
	}
	public List<Hotel> getAll() {
		return repository.findAll();
	}
	
	public Optional<Hotel> getById(long id) {
		return repository.findById(id);
	}
	
	public List<Hotel> getByDestinacija(Destinacija destinacija) {
		return repository.findByDestinacija(destinacija);
	}
	
	public Hotel create(Hotel hotel) {
		return repository.save(hotel);
	}
	public Hotel update(Hotel hotel) {
		return repository.save(hotel);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
