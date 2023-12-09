package org.pallas.alaprest.controllers;

import org.pallas.alaprest.model.ArcResponse;
import org.pallas.alaprest.model.Sincostan;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;

@RestController
public class SincostanGetHW {

    //********Light version********
    @GetMapping("/light/sin/{value1}")
    public double calculateSin (@PathVariable double value1){
        double radians = Math.toRadians(value1);
        return Math.sin(radians);
    }

    @GetMapping("/light/cos/{value}")
    public double calculateCos (@PathVariable double value2){
        double result = Math.cos(value2);
        return result;
    }

    @GetMapping("/light/tan/{value3}")
    public double calculateTan (@PathVariable double value3){
        double result2 = Math.tan(Math.toRadians(value3));
        return result2;
    }

    //********Hard version********
    @RequestMapping(value = "/hard/sin/{q}",method = RequestMethod.GET)
    public Serializable calculateSin(@PathVariable String q){
        int sinValue = 0;
        try{
            sinValue = Integer.parseInt(q);
        } catch (NumberFormatException e){
            return "A " + q + " paraméter szám kell, hogy legyen.";
        }
        double resultSin = Math.toRadians(sinValue);
        return "A sin értéke: " + Math.sin(resultSin);
    }

    @RequestMapping(value = "/hard/cos/{q}",method = RequestMethod.GET)
    public Serializable calculateCos(@PathVariable String q){
        int cosValue = 0;
        try{
            cosValue = Integer.parseInt(q);
        } catch (NumberFormatException e){
            return "A " + q + " paraméter szám kell, hogy legyen.";
        }
        double resultCos = Math.cos(cosValue);
        return "A cos értéke: " + resultCos;
    }

    @RequestMapping(value = "/hard/tan/{q}",method = RequestMethod.GET)
    public Serializable calculateTan(@PathVariable String q){
        int tanValue = 0;
        try{
            tanValue = Integer.parseInt(q);
        } catch (NumberFormatException e){
            return "A " + q + " paraméter szám kell, hogy legyen.";
        }
        double resultTan = Math.tan(Math.toRadians(tanValue));
        return "A tan értéke: " + resultTan;
    }

    //********Final version********
    @RequestMapping(value = "/hard/sincostan/{q}",method = RequestMethod.GET)
    public Serializable calculateSinCosTan(@PathVariable String q){
        ArcResponse response = new ArcResponse();
        Sincostan sincostan = new Sincostan();
        response.setToday(new Date());
        try{
            sincostan.setArcTan(Integer.parseInt(q));
            sincostan.setArcSin(Integer.parseInt(q));
            sincostan.setArcCos(Integer.parseInt(q));
        } catch (NumberFormatException e){
            return "A " + q + " paraméter szám kell, hogy legyen.";
        }
        response.setArcCosResult(Math.cos(Math.toRadians(sincostan.getArcCos())));
        response.setArcTanResult(Math.tan(Math.toRadians(sincostan.getArcTan())));
        response.setArcSinResult(Math.sin(Math.toRadians(sincostan.getArcSin())));

        return response;
    }

}
