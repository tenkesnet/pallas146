package org.retail.models;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bolt_id")
@Table(name = "bolt")
public class Bolt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int boltId;

    @Column(nullable = false)
    public String boltNev;

    @Column(nullable = false)
    public int bevetel;

    @Column(nullable = false)
    public int raktarId;

    @Column(nullable = false)
    public int dolgozokSzama;

    @Column(nullable = false)
    public String cim;
}
