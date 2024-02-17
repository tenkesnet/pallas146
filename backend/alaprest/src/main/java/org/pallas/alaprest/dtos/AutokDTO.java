package org.pallas.alaprest.dtos;

import lombok.Data;
import org.pallas.alaprest.model.Alkalmazott;
import org.pallas.alaprest.model.Rendeles;

@Data
public class AutokDTO {
    private String rendszam;
    private float vetelAr;
    private int futottKm;
    private String alkalmazott;
    private int szervizKm;
    private boolean szervizKoteles;
}
