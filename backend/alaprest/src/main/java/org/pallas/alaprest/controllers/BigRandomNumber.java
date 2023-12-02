package org.pallas.alaprest.controllers;

import org.springframework.stereotype.Component;

@Component("BigRandomNumber")
public class BigRandomNumber implements IRandomNumber {
    private long number;

    public long getNumber(){
        return number*31000;
    }
    public BigRandomNumber(){
        number=Math.round(Math.random()*1000);
    }
}
