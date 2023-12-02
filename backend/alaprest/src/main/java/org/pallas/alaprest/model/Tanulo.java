package org.pallas.alaprest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Tanulo")
public class Tanulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private Date birthDate;

    @Column
    private double weight;
}
