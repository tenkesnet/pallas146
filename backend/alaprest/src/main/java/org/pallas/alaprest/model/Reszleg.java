package org.pallas.alaprest.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "RESZLEG")
public class Reszleg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int reszlegKod;

    @Column(length = 20, nullable = false)
    private String reszlegNev;

    @Column(length = 15, nullable = true)
    private String reszlegCim;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reszleg")
    @JsonBackReference
    private List<Alkalmazott> alkalmazottak = new ArrayList<>();

}
