package rva.model;


import java.io.Serializable;
import java.util.Date;
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
public class Aranzman implements Serializable {

	@Id
	@SequenceGenerator(name = "aranzman_id", sequenceName = "aranzman_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aranzman_id")
	private long id;
	private double  ukupnaCena;
	private Date datumRealizacije;
	private boolean placeno;

	@ManyToOne
	@JoinColumn(name="hotel")
	private Hotel hotel; 
	
	@ManyToOne
	@JoinColumn(name="turistickaAgencija")
	private TuristickaAgencija turistickaAgencija; 
	
	
	public Aranzman() {
		
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public boolean isPlaceno() {
		return placeno;
	}

	public void setPlaceno(boolean placeno) {
		this.placeno = placeno;
	}

	public Date getDatumRealizacije() {
		return datumRealizacije;
	}

	public void setDatumRealizacije(java.util.Date datumRealizacije) {
		this.datumRealizacije = datumRealizacije;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public TuristickaAgencija getTuristickaAgencija() {
		return turistickaAgencija;
	}

	public void setTuristickaAgencija(TuristickaAgencija turistickaAgencija) {
		this.turistickaAgencija = turistickaAgencija;
	}
}
