package org.vegyesbolt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vegyesbolt.dtos.TermekekBaseDTO;
import org.vegyesbolt.mappers.TermekekMapper;
import org.vegyesbolt.models.*;
import org.vegyesbolt.repositories.*;

import java.util.List;

@RestController
public class VegyesboltController {

    @Autowired
    private IBeszallitokRepository beszallitokRepository;

    @Autowired
    private IErtekesitesRepository ertekesitesRepository;

    @Autowired
    private IFenntartasiKoltsegekRepository fenntartasiKoltsegekRepository;

    @Autowired
    private IFinancialRepository financialRepository;

    @Autowired
    private IForgalomRepository forgalomRepository;


    @Autowired
    private IMasterdataRepository masterdataRepository;

    @Autowired
    private ISelejtRepository selejtRepository;

    @Autowired
    private ITermekekRepository termekekRepository;

    @GetMapping("/getBeszallitok")
    public List<Beszallitok> getBeszallitok(){
        return beszallitokRepository.findAll();
    }
    @GetMapping("/getErtekesites")
    public List<Ertekesites> getErtekesites(){
        return ertekesitesRepository.findAll();
    }
    @GetMapping("/getFenntartasiKoltsegek")
    public List<FenntartasiKoltsegek> getFenntartasiKoltsegek(){
        return fenntartasiKoltsegekRepository.findAll();
    }
    @GetMapping("/getFinancial")
    public List<Financial> getFinancial(){
        return financialRepository.findAll();
    }
    @GetMapping("/getForgalom")
    public List<Forgalom> getForgalom(){
        return forgalomRepository.findAll();
    }
    @GetMapping("/getMasterdata")
    public List<Masterdata> getMasterdata(){
        return masterdataRepository.findAll();
    }
    @GetMapping("/getSelejt")
    public List<Selejt> getSelejt(){
        return selejtRepository.findAll();
    }
    @GetMapping("/getTermekek")
    public List<TermekekBaseDTO> getTermekek(){
        List<Termekek> termekek = termekekRepository.findAll();
        return TermekekMapper.MAPPER.fromTermekek(termekek);
        //return termekekRepository.findAll();
    }

}
