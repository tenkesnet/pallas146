package org.pallas.alaprest.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "UGYFELEK")
public class Ugyfelek {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

	@Column(length = 3, nullable = false)
	public int ugyfelSzam;

	@Column(length = 20, nullable = false)
	public String ugyfelNev;

	@Column(length = 15, nullable = false)
	public String cim;

	@Column(length = 10, nullable = false)
	public String varos;

	@Column(length = 10, nullable = false)
	public String orszag;

	@Column(length = 6, nullable = false)
	public int iranyitoSzam;

	@Column(length = 15, nullable = false)
	public String megbizott;

	@Column(length = 1, nullable = false)
	public String fizetesiMod;


	@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "ugyfelek" )
	private List<Rendeles> rendelesek;

}
