package org.agility.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FutamokDTO {
    private Integer id;
    private LocalDateTime kezdoIdopont;
    private String versenynap;
    private int hibapont;
    private BigDecimal ido;
    private int helyezes;
    private int palyahossz;
    private String felvezetonev;
    private int felvezetoKor;
    private String kutyanev;
    private String szint;
    private String meret;
    private String fajta;

}
