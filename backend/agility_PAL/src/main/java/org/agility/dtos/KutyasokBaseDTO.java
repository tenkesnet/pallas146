package org.agility.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class KutyasokBaseDTO {
    public int id;
    public String teljesnev;
    public String cim;
    public int szuldat;
    public BigDecimal kartyaszam;
    private String szerepNev;
}
