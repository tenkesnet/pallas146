package org.pallas.alaprest.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data @NoArgsConstructor @AllArgsConstructor @Embeddable
public class AlkalmazottResponseDTO {
	public Integer id;
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
