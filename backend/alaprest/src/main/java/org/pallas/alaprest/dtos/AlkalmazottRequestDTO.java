package org.pallas.alaprest.dtos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pallas.alaprest.model.Reszleg;

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
	private Reszleg reszleg;

	// @JsonIdentityReference(alwaysAsId = true)
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "alkalmazott")
	//private List<Autok> autok = new ArrayList<>();

}
