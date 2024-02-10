package org.retail.models;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "kozpont_id")
@Table(name = "kozpont")
public class Kozpont {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int kozpontId;

    @Column(nullable = false)
    public String kozpontNev;

    @Column(nullable = false)
    public int bevetel;

    @Column(nullable = false)
    public int kiadas;

    @Column(nullable = false)
    public int dolgozokSzama;

    @Column(nullable = false)
    public String cim;
}
