package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.Aranzman;
import rva.model.Hotel;
import rva.model.TuristickaAgencija;
import rva.repository.AranzmanRepository;

@Service
public class AranzmanService {
	
	@Autowired
	private AranzmanRepository repo;
	public boolean existsById(long id) {
		return getById(id).isPresent();
	}
	public List<Aranzman> getAll() {
		return repo.findAll();
	}
	
	public Optional<Aranzman> getById(long id) {
		return repo.findById(id);
	}
	
	public List<Aranzman> getByHotel(Hotel hotel) {
		return repo.findByHotel(hotel);
	}
	
	public List<Aranzman> getByAgencija(TuristickaAgencija agencija) {
		return repo.findByTuristickaAgencija(agencija);
	}

	public Aranzman create(Aranzman aranzman) {
		return repo.save(aranzman);
	}

	public Aranzman update(Aranzman aranzman) {
		return repo.save(aranzman);
	}
	
	public void deleteById(long id) {
		repo.deleteById(id);
	}
}