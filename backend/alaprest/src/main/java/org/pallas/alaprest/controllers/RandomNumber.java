package org.pallas.alaprest.controllers;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("RandomNumber")
@Primary
public class RandomNumber implements IRandomNumber {
    private long number;

    public long getNumber(){
        return number;
    }
    public RandomNumber(){
        number=Math.round(Math.random()*1000);
    }
}
