package rva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rva.model.TuristickaAgencija;
import rva.repository.TuristickaAgencijaRepository;

@Service
public class TuristickaAgencijaService {
	
	@Autowired
	private TuristickaAgencijaRepository repository;

	public boolean existsById(long id) {
		return repository.existsById(id);
	}
	public List<TuristickaAgencija> getAll() {
		return repository.findAll();
	}
	public Optional<TuristickaAgencija> getById(long id) {
		return repository.findById(id);
	}
	public TuristickaAgencija create(TuristickaAgencija turistickaAgencija) {
		return repository.save(turistickaAgencija);
	}
	public TuristickaAgencija update(TuristickaAgencija agencija) {
		repository.save(agencija);
		return agencija;
	}
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
