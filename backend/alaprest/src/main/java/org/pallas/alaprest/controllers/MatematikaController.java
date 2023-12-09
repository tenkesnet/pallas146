package org.pallas.alaprest.controllers;
import org.pallas.alaprest.interfaces.IRandomNumber;
import org.pallas.alaprest.math.SinRequest;
import org.pallas.alaprest.math.SinResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/matematika")
public class MatematikaController {

    @Autowired
    private IRandomNumber randomNumber;
    @RequestMapping(value = "/sin", method = RequestMethod.GET)
    public ResponseEntity Sin(@RequestParam double a) {
        SinResponse result = new SinResponse();
        result.setValueSin(Math.sin(Math.toRadians(a)));
        result.setValueCos(Math.cos(Math.toRadians(a)));
        result.setValueTan(Math.tan(Math.toRadians(a)));
        result.currentTime = LocalDateTime.now();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/cos", method = RequestMethod.GET)
    public ResponseEntity Cos(@RequestParam double a) {
        SinResponse result = new SinResponse();
        result.setValueSin(Math.sin(Math.toRadians(a)));
        result.setValueCos(Math.cos(Math.toRadians(a)));
        result.setValueTan(Math.tan(Math.toRadians(a)));
        result.currentTime = LocalDateTime.now();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/sin", method = RequestMethod.POST)
    public ResponseEntity Sin(@RequestBody SinRequest sinRequest) {
        SinResponse result = new SinResponse();
        result.setValueSin(Math.sin(Math.toRadians(sinRequest.getA())));
        result.setValueCos(Math.cos(Math.toRadians(sinRequest.getA())));
        result.setValueTan(Math.tan(Math.toRadians(sinRequest.getA())));
        result.currentTime = LocalDateTime.now();
        return new ResponseEntity(result, HttpStatus.OK);


    }

    @RequestMapping(value = "/random" ,method = RequestMethod.GET)
    public String getRandom(){
        return ""+randomNumber.getNumber();
    }
}

