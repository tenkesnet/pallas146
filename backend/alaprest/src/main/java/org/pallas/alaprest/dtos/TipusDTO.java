package org.pallas.alaprest.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TipusDTO {
    public Integer id;
    public String tipusNev;
    public String kivitel;
    public int szervizKm;
}
