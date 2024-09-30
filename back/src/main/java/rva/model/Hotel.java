package rva.model;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Hotel implements Serializable {

	@Id
	@SequenceGenerator(name = "hotel_id", sequenceName = "hotel_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_id")
	private long id;
	private String naziv;
	private String brojZvezdica;
	private String opis;

	@OneToMany(mappedBy = "hotel")
	private List<Aranzman> aranzmani;

	@ManyToOne
	@JoinColumn(name="destinacija")
	private Destinacija destinacija;
	
	public Hotel() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getBrojZvezdica() {
		return brojZvezdica;
	}

	public void setBrojZvezdica(String brojZvezdica) {
		this.brojZvezdica = brojZvezdica;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Destinacija getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}
}
