package org.pallas.alaprest.dtos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UgyfelekDTO {

    public Integer id;
    public String ugyfelNev;
    public String varos;
    public String fizetesiMod;
    public String megbizott;
}
