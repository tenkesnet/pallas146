package org.pallas.alaprest.model;

import org.pallas.alaprest.interfaces.IRandomNumber;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component("RandomNumber")
@Primary
//@RequestScope
//@Scope("singleton")
@SessionScope
public class RandomNumber implements IRandomNumber {
    private long number;

    public long getNumber(){
        return number;
    }
    public RandomNumber(long a){
        number=Math.round(Math.random()*1000);
    }
    public RandomNumber(){
        number=Math.round(Math.random()*1000);
    }
}
