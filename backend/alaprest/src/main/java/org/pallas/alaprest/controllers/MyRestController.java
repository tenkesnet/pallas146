package org.pallas.alaprest.controllers;

import org.pallas.alaprest.interfaces.IRandomNumber;
import org.pallas.alaprest.model.Person;
import org.pallas.alaprest.dtos.PersonResponse;
import org.pallas.alaprest.helper.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {
    @Autowired
    private IRandomNumber randomNumber;

    @RequestMapping(value = "/testpost", method = RequestMethod.POST)
    public ResponseEntity<PersonResponse> ElnokEmberei(@RequestBody Person person){
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

    @RequestMapping(value = "/prim",method = RequestMethod.GET)
    public String legnagyobbPrim(@RequestParam(required = false) String q){
        if(q==null){
            return "kell egy q paraméter";
        }
        int jegyekSzama=0; // "3" -> 3
        try{
            jegyekSzama=  Integer.parseInt(q);
        } catch(NumberFormatException e){
            return "A q paraméter szám kell legyen";
        }
        long i;
        for(i=(long)Math.pow(10,jegyekSzama)-1; i>2;i--){
            if(Util.isPrime(i)){
                break;
            }
        }
        return "{ \"maxPrim\":"+i+"}";
    }
    @RequestMapping(value = "/random" ,method = RequestMethod.GET)
    public String getRandom(){
        return ""+randomNumber.getNumber();
    }

}
