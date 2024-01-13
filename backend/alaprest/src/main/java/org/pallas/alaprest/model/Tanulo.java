package org.pallas.alaprest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "Tanulo")
public class Tanulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private LocalDate birthDate;

    @Column
    private double weight;

    @Column
    private String hajSzin;


    @Override
    public String toString() {
        return "Tanulo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                ", hajSzin='" + hajSzin + '\'' +
                '}';
    }
}
