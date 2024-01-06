package org.pallas.alaprest.controllers;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.Serializable;

@RestController
public class XYController {

    @RequestMapping(value = "/xynumber/{q}", method = RequestMethod.GET)
    public Serializable numberRequest(@PathVariable String q) {
        int number = 0;
        try {
            number = Integer.parseInt(q);
        } catch (NumberFormatException e) {
            return "A" + q + " paraméter szám kell, hogy legyen.";
        }
        int resultXY = number * 2;
        return "Az XY szám értéke: " + resultXY;
    }

    @RequestMapping(value = "/invers/{q}", method = RequestMethod.GET)
    public Serializable invers(@PathVariable String q) {
        String string = q, nstr = "";
        char ch;
        for (int i = 0; i < string.length(); i++) {
            ch = string.charAt(i);
            nstr = ch + nstr;
        }
        return "Reserved word: " + nstr;
    }

    @RequestMapping(value = "/siklos/{s}", method = RequestMethod.GET)
    public RedirectView siklos(@PathVariable String s) {
        String siklosUrl = "http://www.siklos.hu";
        return new RedirectView(siklosUrl);
    }

    public String website = "http://www.siklos.hu";

    @RequestMapping(value = "/oraimunka/{q}/{w}", method = RequestMethod.GET)
    public Object getOutput(@PathVariable String q, @PathVariable String w) {
        if (true) {
            try {
                int numberInput1 = Integer.parseInt(q);
                int numberInput2 = Integer.parseInt(w);
                if (numberInput2 == 0) {
                    return "Hiba: nullával nem lehet osztani.";
                }
                return (double) numberInput1 / numberInput2;
            }catch (NumberFormatException e) {
                return "A megadott " + q + " és " + w + " paraméter mindegyike szám kell, hogy legyen.";
                /*return (Object) new RedirectView(website);*/
            }
        }else{
            return (Object) new RedirectView(website);
        }
    }
}






















