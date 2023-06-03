package org.pallas;

import org.pallas.Kamion;
import org.pallas.TeherAuto;

public class Hello extends TeherAuto {
    TeherAuto szia;
    public Hello(){
        super("",0.0,0);
        szia= new Kamion(1,1,"piros");
        TeherAuto szia2= new Kamion(1,1,"sarga");
        this.szia.marka="fiat";
    }
}
