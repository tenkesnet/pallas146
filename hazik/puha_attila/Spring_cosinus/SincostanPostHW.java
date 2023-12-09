package org.pallas.alaprest.controllers;

import org.pallas.alaprest.models.ArcResponse;
import org.pallas.alaprest.models.Sincostan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class SincostanPostHW {

    @RequestMapping(value = "/arcsincostan", method = RequestMethod.POST)
    public ResponseEntity calculateArcSin1 (@RequestBody Sincostan sincostan){
        ArcResponse result = new ArcResponse();
        Date dateOfCheck = new Date();
        result.setToday(dateOfCheck);
        result.setArcSinResult(Math.asin(sincostan.getArcSin()));
        result.setArcCosResult(Math.acos(sincostan.getArcCos()));
        result.setArcTanResult(Math.atan(sincostan.getArcTan()));
        return new ResponseEntity(result, HttpStatus.OK);
    }


}