package org.pallas.alaprest.controllers;

import org.pallas.alaprest.dtos.*;
import org.pallas.alaprest.mappers.*;
import org.pallas.alaprest.model.*;
import org.pallas.alaprest.repository.*;
import org.pallas.alaprest.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @RequestMapping(value = "getAlkalmazottak", method = RequestMethod.GET)
    public ResponseEntity getAlkalmazottak() {
        List<AlkalmazottDTO> alkalmazott = modelService.getAlkalmazottak();
        return new ResponseEntity(alkalmazott, HttpStatus.OK);
    }

    @RequestMapping(value = "getAutok", method = RequestMethod.GET)
    public ResponseEntity getAutok() {
        List<AutokDTO> autok = modelService.getAutok();
        return new ResponseEntity(autok,HttpStatus.OK);
    }
    @RequestMapping(value = "getRendelesek", method = RequestMethod.GET)
    public ResponseEntity getRendeles() {
        List<RendelesDTO> rendeles = modelService.getRendeles();
        return new ResponseEntity(rendeles, HttpStatus.OK);
    }
    @RequestMapping(value = "getUgyfelek", method = RequestMethod.GET)
    public ResponseEntity getUgyfelek() {
        List<UgyfelekDTO> ugyfelek = modelService.getUgyfelek();
        return new ResponseEntity(ugyfelek, HttpStatus.OK);
    }
    @RequestMapping(value="getAutoCsop", method = RequestMethod.GET)
    public ResponseEntity getAutoCsop(){
        List<AutoCsopDTO> autoCsop = modelService.getAutoCsop();
        return new ResponseEntity(autoCsop, HttpStatus.OK);
    }
    @RequestMapping(value = "getTipus", method = RequestMethod.GET)
    public ResponseEntity getTipus(){
        List<TipusDTO> tipus= modelService.getTipus();
        return new ResponseEntity(tipus, HttpStatus.OK);
    }
    @RequestMapping(value = "getReszleg", method = RequestMethod.GET)
    public ResponseEntity getReszleg(){
        List<Reszleg> reszleg = modelService.getReszleg();
        return new ResponseEntity(reszleg, HttpStatus.OK);
    }

    @RequestMapping(value = "postAutoCsop", method = RequestMethod.POST)
    public ResponseEntity addAutoCsop (@RequestBody AutoCsopRequestDTO autoCsopRequestDTO){
        return new ResponseEntity<>(modelService.addAutoCsop(autoCsopRequestDTO),HttpStatus.OK);
    }

    @RequestMapping(value = "postAlkalmazott", method = RequestMethod.POST)
    public ResponseEntity addAlkalmazott (@RequestBody AlkalmazottRequestDTO alkalmazottRequestDTO){
        return new ResponseEntity<>(modelService.addAlkalmazott(alkalmazottRequestDTO),HttpStatus.OK);
    }


}
