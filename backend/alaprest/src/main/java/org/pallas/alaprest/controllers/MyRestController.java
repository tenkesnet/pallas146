package org.pallas.alaprest.controllers;

import org.pallas.alaprest.models.Person;
import org.pallas.alaprest.dtos.PersonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    @RequestMapping(value = "/testpost", method = RequestMethod.POST)
    public ResponseEntity ElnokEmberei(@RequestBody Person person){
        PersonResponse result = new PersonResponse();
        result.setName(person.getName());
        if(person.getAge()<18){
            return new ResponseEntity("Nem jó életkor", HttpStatus.BAD_REQUEST);
        }
        result.setBirthYear(2023-person.getAge());
        result.setAddress(person.getAddress());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    //@RequestMapping(value = "/testpost",headers = {"tag=pallas","eloado=bardo"},method = RequestMethod.GET)
    @RequestMapping(value = "/testpost/{q}/lekerdezes/{e}",method = RequestMethod.GET)
    public String Vajak(@PathVariable String q,@PathVariable String e){
        return "Ez egy GET végpont :"+q+" , "+e;
    }

    @RequestMapping(value = "/testpost2",method = RequestMethod.GET)
    public String teszt(@RequestParam(required = false) String q){
        if(q==null){
            return "Ez egy GET végpont.";
        }
        return "Ez egy GET végpont :"+q;
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.PUT)
    public String Attila(){
        return "Ez egy PUT végpont";
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.DELETE)
    public String Csaba(){
        return "Ez egy DELETE végpont";
    }
}
