package org.pallas.alaprest.controllers;

import org.pallas.alaprest.model.Alkalmazott;
import org.pallas.alaprest.repository.IAlkalmazottRepository;
import org.pallas.alaprest.repository.IReszlegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alkalmazott")
public class AlkalmazottController {
    @Autowired
    private IAlkalmazottRepository alkalmazottRepository;
    @Autowired
    private IReszlegRepository reszlegRepository;
    @GetMapping("getAll")
    public List<Alkalmazott> getAll(){
        return alkalmazottRepository.findAll();
    }

    /*@GetMapping("{id}")
    public ResponseEntity getByid(@PathVariable String id){
        try {
            int idTemp=Integer.parseInt(id);
            Alkalmazott a=alkalmazottRepository.findById(idTemp).get();
            AlkalmazottDTO aDTO = new AlkalmazottDTO(a.getId(), a.getAlkKod(), a.getAlkNev(), a.getBeosztas(), a.getFizetes(), a.getPremium(), a.getBelepes(), null);
            Optional<Reszleg> r = reszlegRepository.findById(a.getReszleg().getId());
            Reszleg reszleg = r.get();
            reszleg.setAlkalmazottak(null);
            aDTO.setReszleg(reszleg);
            return new ResponseEntity(aDTO, HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        } catch (NumberFormatException e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }*/


}
