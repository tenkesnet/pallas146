package org.pallas.alaprest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "RENDELES")
public class Rendeles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 5, nullable = false)
    public int rendelesSzam;

	@JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "UGYFELEK_ID")
    private Ugyfelek ugyfelek;


    public Date rendelesDatum;

    @Column(length = 12, nullable = false)
    public String rendeloSzemely;

    public Date kolcsonKezdete;

    public int napok;
	@JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "RENDSZAM_ID", referencedColumnName = "ID")
	@JsonManagedReference
    private Autok autok;

	@JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TIPUSOK_ID", referencedColumnName = "ID")
	@JsonManagedReference
    private Tipus tipus;

    private Integer kmKezdet;

    private Integer kmVeg;

    private Integer kolcsonDij;

    @Column(length = 12, nullable = false)
    public String fizetes;

}
