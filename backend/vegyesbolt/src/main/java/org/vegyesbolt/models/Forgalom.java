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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "forgalomId")
@Table(name = "forgalom")
public class Forgalom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int forgalomId;
    @Column(nullable = false)
    public Date datum;
    @Column(nullable = false)
    public int napiBevetel;
    @Column(nullable = false)
    public int napiKiadas;
    @Column(nullable = false)
    public int summaForgalom;
}
