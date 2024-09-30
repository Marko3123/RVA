package rva.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "agencija")
public class TuristickaAgencija implements Serializable {

	@Id
	@SequenceGenerator(name = "agencija_id", sequenceName = "agencija_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agencija_id")
	private long id;
	private String naziv;
	private String adresa;
	private String kontakt;
	
	@OneToMany(mappedBy = "turistickaAgencija")
	private List<Aranzman> aranzmani;

	public TuristickaAgencija() {
		
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

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
}
