package org.pallas.alaprest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import static java.lang.Integer.parseInt;

@RestController
public class NumberController {

    @RequestMapping(value = "/number/{q}", method = RequestMethod.GET)
    public String szo(@PathVariable String q) {
        /*String fordString ="";

        for (int i=0; i< q.length();i++ ){
            fordString=q.charAt(i)+fordString;
            //fordString=fordString+q.charAt(i);
        }*/

        return "A szó forditottja : " + new StringBuilder(q).reverse() ;
    }
    @RequestMapping(value = "/siklos", method = RequestMethod.GET)
    public ResponseEntity Siklos3 (@RequestParam(required = false) String a, @RequestParam(required = false) String b) {
        if (a != null && b != null) {
            int szorzat = 0;

            try {
                szorzat = Integer.parseInt(a) * Integer.parseInt(b);
            } catch (NumberFormatException e) {
                return new ResponseEntity("A paraméterek számok legyen!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity(szorzat, HttpStatus.OK);

        } else {
            return new ResponseEntity("Rhia", HttpStatus.OK);
        }
    }


    /*@RequestMapping(value= "/siklos", method = RequestMethod.GET)
    public ResponseEntity Siklos (@RequestParam String a, @RequestParam String b) {
        if (a == null && b == null) {
            return new ResponseEntity("Két paramétert kérek!", HttpStatus.OK);
        }  else {
            int szorzat = 0;
            try {
                szorzat = Integer.parseInt(a) * Integer.parseInt(b);
            } catch (NumberFormatException e) {
                return new ResponseEntity("A paraméterek számok legyen!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity(szorzat, HttpStatus.OK);
        }
    }
    @RequestMapping(value= "/siklos", method = RequestMethod.GET)
    public RedirectView Siklos1 () {
        String siklosUrl = "https://www.siklos.hu/";
        return new RedirectView(siklosUrl); }
/*
    @RequestMapping(value= "/siklos", method = RequestMethod.GET)
    public ResponseEntity Siklos2 (@RequestParam String a) {
        int nullaSzorzat = 0;
        try {
            nullaSzorzat = Integer.parseInt(a) * 0;
        } catch (NumberFormatException e) {
            return new ResponseEntity("A paraméter szám legyen!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(nullaSzorzat, HttpStatus.OK); }*/





}
