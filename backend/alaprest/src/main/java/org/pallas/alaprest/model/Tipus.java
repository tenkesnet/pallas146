package org.pallas.alaprest.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.*;
import lombok.Data;
import org.pallas.alaprest.model.Autok;

import java.util.List;

@Entity
@Data
@Table(name = "TIPUSOK")
public class Tipus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 6, nullable = false)
    public String  tipusNev ;

    @Column(length = 6, nullable = false)
    public String  leiras ;
    public int SzervizKm;

	@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "tipus")
	private List<Autok> autok;

	@JsonIdentityReference(alwaysAsId = true)
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "tipus")
	private List <Rendeles> rendeles;


}