package org.pallas.alaprest.controllers;

import org.pallas.alaprest.interfaces.IRandomNumber;
import org.pallas.alaprest.model.RandomNumber;
import org.pallas.alaprest.model.Person;
import org.pallas.alaprest.dtos.PersonResponse;
import org.pallas.alaprest.model.Tanulo;
import org.pallas.alaprest.repository.ITanuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.pallas.alaprest.helper.Util.isPrime;

import org.pallas.alaprest.helper.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

@RestController
public class MyRestController {

    @Autowired
    private IRandomNumber randomNumber;

    @Autowired
    private ITanuloRepository tanuloRepository;

    @RequestMapping(value = "/testpost", method = RequestMethod.POST)
    public ResponseEntity<PersonResponse> ElnokEmberei(@RequestBody Person person) {
        PersonResponse result = new PersonResponse();
        result.setName(person.getName());
        if (person.getAge() < 18) {
            return new ResponseEntity("Nem jó életkor", HttpStatus.BAD_REQUEST);
        }
        result.setBirthYear(2023 - person.getAge());
        result.setAddress(person.getAddress());

        return new ResponseEntity(result, HttpStatus.OK);
    }

    //@RequestMapping(value = "/testpost",headers = {"tag=pallas","eloado=bardo"},method = RequestMethod.GET)
    @RequestMapping(value = "/testpost/{q}/lekerdezes/{e}", method = RequestMethod.GET)
    public String Vajak(@PathVariable String q, @PathVariable String e) {
        return "Ez egy GET végpont :" + q + " , " + e;
    }

    @RequestMapping(value = "/testpost2", method = RequestMethod.GET)
    public ResponseEntity teszt(@RequestParam(required = false) String q, @RequestParam(required = false) String d) {
        List<Tanulo> tanulok = tanuloRepository.findAll();
        //List<Tanulo> tanulok = tanuloRepository.findAllByOrderByIdDesc();
        if (q != null) {
            tanulok = tanuloRepository.findByHajSzin(q);
            return new ResponseEntity(tanulok, HttpStatus.OK);
        }
        if (d != null) {
            LocalDate date;
            try {
                date = LocalDate.parse(d);
            } catch (DateTimeParseException e) {
                date = LocalDate.parse("1975-01-20");
            }

            tanulok = tanuloRepository.findByBirthDate(date);
            return new ResponseEntity(tanulok, HttpStatus.OK);
        }
        /*if(q==null){
            return "Ez egy GET végpont.";
        }
        return "Ez egy GET végpont :"+q;
        for(Tanulo tanulo:tanulok){

        }*/
        return new ResponseEntity(tanulok, HttpStatus.OK);
    }

    @RequestMapping(value = "/testpost2", method = RequestMethod.POST)
    public ResponseEntity tesztPost(@RequestBody Tanulo tanulo) {
        tanuloRepository.save(tanulo);
        List<Tanulo> tanulok = tanuloRepository.findAllByOrderByIdAsc();
        return new ResponseEntity(tanulok, HttpStatus.OK);
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.PUT)
    public String Attila() {
        return "Ez egy PUT végpont";
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.DELETE)
    public String Csaba() {
        return "Ez egy DELETE végpont";
    }

    @RequestMapping(value = "/prim", method = RequestMethod.GET)
    public String legnagyobbPrim(@RequestParam(required = false) String q) {
        if (q == null) {
            return "kell egy q paraméter";
        }
        int jegyekSzama = 0; // "3" -> 3
        try {
            jegyekSzama = Integer.parseInt(q);
        } catch (NumberFormatException e) {
            return "A q paraméter szám kell legyen";
        }
        long i;
        for (i = (long) Math.pow(10, jegyekSzama) - 1; i > 2; i--) {
            if (isPrime(i)/*Util.isPrime(i)*/) {
                break;
            }
        }
        return "{ \"maxPrim\":" + i + "}";
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public String getRandom() {
        return "" + randomNumber.getNumber();
    }

    @RequestMapping(value = "/testpost3", method = RequestMethod.GET)
    public ResponseEntity test(@RequestParam(required = false) String q, @RequestParam(required = false) String from, @RequestParam(required = false) String to) {
        List<Tanulo> fiatalok = tanuloRepository.findAll();
        if (q == null && from == null && to == null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN);
            LocalDate date;
            try {
                date = LocalDate.parse("1980-01-01");
            } catch (DateTimeParseException e) {
                date = LocalDate.parse("1980-01-01");
            }
            fiatalok = tanuloRepository.findByBirthDateLessThan(date);
            return new ResponseEntity(fiatalok, HttpStatus.OK);
        }
        if (q != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN);
            LocalDate start;
            LocalDate end;
            try {
                start = LocalDate.parse("1980-01-01");
                end = LocalDate.parse("1990-12-31");
            } catch (DateTimeParseException e) {
                start = LocalDate.parse("1980-01-01");
                end = LocalDate.parse("1990-12-31");
            }
            fiatalok = tanuloRepository.findByBirthDateBetween(start, end);
            return new ResponseEntity(fiatalok, HttpStatus.OK);
        }
        if (from != null && to != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN);
            LocalDate fromDate;
            LocalDate toDate;
            try {
                fromDate = LocalDate.parse(from);
                toDate = LocalDate.parse(to);
            } catch (DateTimeParseException e) {
                fromDate = LocalDate.parse("1985-01-01");
                toDate = LocalDate.parse("2001-01-01");
            }
            fiatalok = tanuloRepository.findByBirthDateBetween(fromDate, toDate);
            return new ResponseEntity(fiatalok, HttpStatus.OK);
        }
        return new ResponseEntity(fiatalok, HttpStatus.OK);
    }
}
