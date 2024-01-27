package org.vegyesbolt.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "ertekesites")
public class Ertekesites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int ertekesitesId;
    @Column(nullable = false)
    public Date ertekesitesiDatum;
    @Column(nullable = false)
    public Time ertekesitesiIdo;
    @Column(nullable = false)
    public int vasarloiLetszam;
    @Column(nullable = false)
    public int bevetel;
}
