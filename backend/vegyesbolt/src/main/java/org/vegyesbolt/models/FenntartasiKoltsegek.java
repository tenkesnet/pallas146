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
@Table(name = "fenntartasi_koltsegek")
public class FenntartasiKoltsegek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int koltsegId;
    @Column(nullable = false)
    public String koltsegMegnevezes;
    @Column(nullable = false)
    public String koltsegIntenzitas;
    @Column(nullable = false)
    public String koltsegTipus;
    @Column(nullable = false)
    public int koltsegMerteke;
}