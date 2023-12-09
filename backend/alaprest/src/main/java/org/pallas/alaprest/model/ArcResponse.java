package org.pallas.alaprest.model;

import java.io.Serializable;
import java.util.Date;

public class ArcResponse implements Serializable {

    private Date today;
    private double arcSinResult;

    private double arcCosResult;

    private double arcTanResult;

    public double getArcSinResult() {
        return arcSinResult;
    }

    public void setArcSinResult(double arcSinResult) {
        this.arcSinResult = arcSinResult;
    }

    public double getArcCosResult() {
        return arcCosResult;
    }

    public void setArcCosResult(double arcCosResult) {
        this.arcCosResult = arcCosResult;
    }

    public double getArcTanResult() {
        return arcTanResult;
    }

    public void setArcTanResult(double arcTanResult) {
        this.arcTanResult = arcTanResult;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }
}
