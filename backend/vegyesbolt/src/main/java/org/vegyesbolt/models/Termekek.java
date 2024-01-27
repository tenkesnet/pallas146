package org.vegyesbolt.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "termekId")
@Table(name = "termekek")
public class Termekek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int termekId;
    @Column(nullable = false)
    public String termekMegnevezes;
    @Column(nullable = false)
    public String termekTipus;
    @Column(nullable = false)
    public int termekBeszerzesiAr;
    @Column(nullable = false)
    public int termekEladasiAr;
    @Column(nullable = false)
    public int termekProfit;
    @Column
    public Integer szavatossagiIdoHonap;

    //Ide már kell kapcsolatot írni!
    @ManyToOne
    @JoinColumn(name = "beszallito_id", nullable = false)
    private Beszallitok beszallitok;
}
