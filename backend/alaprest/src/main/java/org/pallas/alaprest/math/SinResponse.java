package org.pallas.alaprest.math;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class SinResponse {
    @Getter
    @Setter
    private double valueSin;

    @Setter
    @Getter
    private double valueCos;

    @Setter
    @Getter
    private double valueTan;

    public LocalDateTime currentTime;
}

