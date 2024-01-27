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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "financial")
public class Financial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int financialId;


    //Ide már kell kapcsolatot írni!
    @ManyToOne
    @JoinColumn(name = "forgalom_id", nullable = false)
    private Forgalom forgalom;
    @ManyToOne
    @JoinColumn(name = "koltseg_id", nullable = false)
    private FenntartasiKoltsegek fenntartasiKoltsegek;
    @ManyToOne
    @JoinColumn(name = "ertekesites_id", nullable = false)
    private Ertekesites ertekesites;
    @ManyToOne
    @JoinColumn(name = "kiadas_id", nullable = false)
    private Kiadas kiadas;
}
