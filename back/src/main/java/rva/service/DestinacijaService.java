package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Destinacija;
import rva.repository.DestinacijaRepository;

@Service
public class DestinacijaService {
	
	@Autowired
	private DestinacijaRepository repository;

	public boolean existsById(long id) {
		return repository.existsById(id);
	}
	public List<Destinacija> getAll() {
		return repository.findAll();
	}
	
	public Optional<Destinacija> getById(long id) {
		return repository.findById(id);
	}
	
	public Destinacija save(Destinacija destinacija) {
		return repository.save(destinacija);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
