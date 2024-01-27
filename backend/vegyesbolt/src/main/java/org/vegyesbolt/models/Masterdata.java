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
@Table(name = "masterdata")
public class Masterdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int masterdataId;


    //Ide már kell kapcsolatot írni!
    @ManyToOne
    @JoinColumn(name = "selejt_id", nullable = false)
    private Selejt selejt;
    @ManyToOne
    @JoinColumn(name = "beszallito_id", nullable = false)
    private Beszallitok beszallitok;
    @ManyToOne
    @JoinColumn(name = "termek_id", nullable = false)
    private Termekek termekek;
}
