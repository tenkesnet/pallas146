package org.pallas.alaprest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "TIPUSOK")
public class Tipus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 6, nullable = false)
    public String  tipusNev ;

    @Column(length = 6, nullable = false)
    public String leiras ;
    public int szervizKm;

    @ManyToOne
    @JoinColumn(name = "AUTO_CSOP_ID", referencedColumnName = "ID")
    public AutoCsop autoCsop;

	@JsonIdentityReference(alwaysAsId = true)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tipus")
    @JsonBackReference
    private List<Rendeles> rendeles = new ArrayList<>();

	@JsonIdentityReference(alwaysAsId = true)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tipus")
    @JsonBackReference
    private List<Autok> autok = new ArrayList<>();


}