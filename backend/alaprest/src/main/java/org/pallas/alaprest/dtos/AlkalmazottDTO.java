package org.pallas.alaprest.dtos;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pallas.alaprest.model.Reszleg;

import java.time.LocalDate;
import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor @Embeddable
public class AlkalmazottDTO {
	public int id;
	public String nev;
	public String beosztas;
	public Integer fizetes;
	public Integer premium;
	public LocalDate belepes;
	private String reszlegNev;

	// @JsonIdentityReference(alwaysAsId = true)
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "alkalmazott")
	//private List<Autok> autok = new ArrayList<>();

}
