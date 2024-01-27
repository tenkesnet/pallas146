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
@Table(name = "selejt")
public class Selejt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int selejtId;
    @Column(nullable = false)
    public Date selejtBekerulesiDatum;
    @Column(nullable = false)
    public int zoldsegSelejtMennyiseg;
    @Column(nullable = false)
    public int tejtermekSelejtMennyiseg;
    @Column(nullable = false)
    public int pekaruSelejtMennyiseg;
    @Column(nullable = false)
    public int gyumolcsSelejtMennyiseg;
    @Column(nullable = false)
    public int husSelejtMennyiseg;

}
