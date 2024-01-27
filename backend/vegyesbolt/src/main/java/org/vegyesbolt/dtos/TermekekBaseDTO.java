package org.vegyesbolt.dtos;

import jakarta.persistence.Column;

public class TermekekBaseDTO {
    public int termekId;
    public String termekMegnevezes;
    public String termekTipus;
    public int termekBeszerzesiAr;
    public int termekEladasiAr;
    public int termekProfit;
    public Integer szavatossagiIdoHonap;
}
