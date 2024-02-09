package org.agility.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.agility.models.Kutyafajtak;
import org.agility.models.Meretkategoria;
import org.agility.models.Szintkategoria;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "kutyak")
public class Kutyak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(nullable = false)
    public String hivonev;
    @Column(nullable = false)
    public BigDecimal kor;
    @ManyToOne
    @JoinColumn(name = "fajta_id", nullable = false)
    private Kutyafajtak fajta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meretkat_id", nullable = false)
    private Meretkategoria meretkat;
    @ManyToOne
    @JoinColumn(name = "szintkat_id", nullable = false)
    private Szintkategoria szintkat;
}
