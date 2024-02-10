package org.pallas.alaprest.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
//	
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
}
