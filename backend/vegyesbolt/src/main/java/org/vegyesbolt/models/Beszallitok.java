package org.vegyesbolt.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "beszallitok")
public class Beszallitok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int beszallitoId;
    @Column(nullable = false)
    public String beszallitoMegnevezes;
    @Column(nullable = false)
    public String beszallitoRegio;
    @Column(nullable = false)
    public int iranyitoszam;
    @Column(nullable = false)
    public String varos;
    @Column(nullable = false)
    public String utcaHazszam;
}
