package com.example.Agility.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "futamok")
public class Futamok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(nullable = false)
    public LocalDate kezdoIdopont;
    @Column(nullable = false)
    public int hiba;
    @Column(nullable = false)
    public BigDecimal ido;
    @Column(nullable = false)
    public int eredmeny;
    @Column(nullable = false)
    public int palyahossz;

    @ManyToOne
    @JoinColumn(name = "kutya_id", nullable = false)
    private Kutyak kutyak;
    @ManyToOne
    @JoinColumn(name = "kutyasok_id", nullable = false)
    private Kutyasok kutyasok;

}
