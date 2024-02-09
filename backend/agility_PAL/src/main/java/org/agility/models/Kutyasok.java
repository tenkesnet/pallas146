package org.agility.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.agility.models.Szerep;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "kutyasok")
public class Kutyasok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(nullable = false)
    public String teljesnev;
    @Column(nullable = false)
    public String cim;
    @Column(nullable = false)
    public Date szuldat;
    @Column(nullable = false)
    public BigDecimal kartyaszam;
    @ManyToOne
    @JoinColumn(name = "szerep_id", nullable = false)
    private Szerep szerep;
}
