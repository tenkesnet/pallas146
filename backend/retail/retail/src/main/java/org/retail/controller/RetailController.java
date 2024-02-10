package org.retail.controller;

import org.retail.dtos.RaktarDTO;
import org.retail.mappers.RaktarMapper;
import org.retail.models.Beszallito;
import org.retail.models.Bolt;
import org.retail.models.Kozpont;
import org.retail.models.Raktar;
import org.retail.repositories.IBeszallitoRepository;
import org.retail.repositories.IBoltRepository;
import org.retail.repositories.IKozpontRepository;
import org.retail.repositories.IRaktarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RetailController {

    @Autowired
    private IBoltRepository boltRepository;

    @GetMapping("getBolt")
    public List<Bolt> getBolt(){
        return boltRepository.findAll();
    }

    @Autowired
    private IBeszallitoRepository beszallitoRepository;
    @GetMapping("getBeszallito")
    public List<Beszallito> getBeszallito(){
        return beszallitoRepository.findAll();
    }

    @Autowired
    private IRaktarRepository raktarRepository;
    @GetMapping("getRaktar")
    public List<RaktarDTO> getRaktar (){
        List<Raktar>raktar = raktarRepository.findAll();
        return RaktarMapper.MAPPER.fromRaktar(raktar);
    }

    @Autowired
    private IKozpontRepository kozpontRepository;
    @GetMapping("getKozpont")
    public List<Kozpont> getKozpont(){
        return kozpontRepository.findAll();
    }
}
