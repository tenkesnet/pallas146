package org.vegyesbolt.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TermekekBaseDTO {
    public int termekId;
    public String termekMegnevezes;
    public String termekTipus;
    public int termekBeszerzesiAr;
    public int termekEladasiAr;
    public int termekProfit;
    public Integer szavatossagiIdoHonap;
    public String beszallito;
}
