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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "raktar_id")
@Table(name = "raktar")
public class Raktar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int raktarId;

    @Column(nullable = false)
    public String raktarNev;

    @Column(nullable = false)
    public int dolgozokSzama;

    @Column(nullable = false)
    public String cim;

    @Column(nullable = false)
    public int kozpontId;
}
