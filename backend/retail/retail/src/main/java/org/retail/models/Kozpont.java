package org.retail.models;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "kozpontId")
@Table(name = "kozpont")
public class Kozpont {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer kozpontId;

    @Column(nullable = false)
    public String kozpontNev;

    @Column(nullable = false)
    public Integer bevetel;

    @Column(nullable = false)
    public Integer kiadas;

    @Column(nullable = false)
    public Integer dolgozokSzamaKozpont;

    @Column(nullable = false)
    public String cim;

    @OneToMany(mappedBy = "kozpont")
    @JsonManagedReference
    List<Raktar> raktarak;

    @OneToMany(mappedBy = "kozpont")
    @JsonManagedReference
    List<Beszallito> beszallitok;
}
