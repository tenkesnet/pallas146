package org.pallas.alaprest.dtos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AlkalmazottRequestDTO {
	public Integer alkKod;
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
