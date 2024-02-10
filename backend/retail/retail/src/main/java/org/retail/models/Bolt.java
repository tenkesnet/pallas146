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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "boltId")
@Table(name = "bolt")
public class Bolt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer boltId;

    @Column(nullable = false)
    public String boltNev;

    @Column(nullable = false)
    public Integer bevetel;

    @Column(nullable = false)
    public Integer dolgozokSzama;

    @Column(nullable = false)
    public String cim;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "raktar_id")
    public Raktar raktar;
}