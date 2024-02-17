package org.pallas.alaprest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "AUTOK")
public class Autok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String rendszam;

    private Date vasarlasDatuma;

    private float ar;

    private int futottKm;

    @Nullable
    private Integer utSzerviz;

    @Column(length = 1, nullable = false)
    private String allapot;

   
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "RESZLEG_ID", referencedColumnName = "ID")
    @JsonManagedReference
    private Reszleg reszleg;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ALKALMAZOTT_ID", referencedColumnName = "ID")
    @JsonManagedReference
    private Alkalmazott alkalmazott;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "AUTO_CSOP_ID", referencedColumnName = "ID")
    @JsonManagedReference
    private AutoCsop autoCsop;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TIPUSOK_ID", referencedColumnName = "ID")
    @JsonManagedReference
    private Tipus tipus;

    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "autok")
    @JsonBackReference
    private List<Rendeles> rendeles = new ArrayList<>();



}
