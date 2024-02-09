package org.agility.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@IdClass(FutamokId.class)
@Table(name = "futamok")
public class Futamok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Id
    @Column(nullable = false)
    private LocalDateTime kezdoIdopont;

    @Column(length = 2, nullable = false)
    private int hiba;

    @Column(length = 7, nullable = false)
    private BigDecimal ido;

    @Column(length = 3, nullable = false)
    private int eredmeny;

    @Column(length = 3, nullable = false)
    private int palyahossz;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "kutyasok_id")
    private Kutyasok kutyasok;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "kutya_id")
    private Kutyak kutyak;


}
class FutamokId implements Serializable{
    private int id;
    private LocalDateTime kezdoIdopont;
    private int kutyak;

}

