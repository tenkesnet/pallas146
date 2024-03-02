package org.pallas.alaprest.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "ALKALMAZOTT")
public class Alkalmazott {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public Integer alkKod;
	@Column(length = 20, nullable = false)
	public String alkNev;
	@Column(length = 16, nullable = false)
	public String beosztas;
	public Integer fizetes;
	@Column(nullable = true)
	public Integer premium;
	public LocalDate belepes;

	//@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "RESZLEG_ID", referencedColumnName = "ID")
	@JsonManagedReference
	private Reszleg reszleg;

	@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "alkalmazott")
	@JsonBackReference
	private List<Autok> autok = new ArrayList<>();

}
