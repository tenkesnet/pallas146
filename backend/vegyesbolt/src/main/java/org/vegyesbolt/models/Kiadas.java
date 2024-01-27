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
@Table(name = "kiadas")
public class Kiadas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int kiadasId;
    @Column(nullable = false)
    public Date kiadasDatum;
    @Column(nullable = false)
    public int kiadas;

    //Ide már kell kapcsolatot írni!
    @ManyToOne
    @JoinColumn(name = "beszallito", nullable = false)
    private Termekek termekek;
}
