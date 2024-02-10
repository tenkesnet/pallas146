package org.retail.models;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Embeddable
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "raktarId")
@Table(name = "raktar")
public class Raktar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer raktarId;

    @Column(nullable = false)
    public String raktarNev;

    @Column(nullable = false)
    public Integer dolgozokSzamaRaktar;

    @Column(nullable = false)
    public String cim;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "kozpont_id")
    @JsonBackReference
    public Kozpont kozpont;

    @OneToMany(mappedBy = "raktar")
    @JsonManagedReference
    List<Bolt> boltok;
}
