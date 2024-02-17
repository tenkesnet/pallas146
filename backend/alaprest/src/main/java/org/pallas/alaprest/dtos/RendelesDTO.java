package org.pallas.alaprest.dtos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RendelesDTO {

    public Integer id;
    public Integer rendelesSzam;
    public Date rendelesDatum;
    private String rendszam;
    private String autoTipus;
    private String ugyfelNev;
}
