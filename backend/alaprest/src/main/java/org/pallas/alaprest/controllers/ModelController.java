package org.pallas.alaprest.controllers;

import org.pallas.alaprest.dtos.*;
import org.pallas.alaprest.mappers.*;
import org.pallas.alaprest.model.*;
import org.pallas.alaprest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private IAlkalmazottRepository alkalmazottRepository;
    @Autowired
    private IReszlegRepository reszlegRepository;
    @Autowired
    private IAutoCsopRepository autoCsopRepository;
    @Autowired
    private IAutokRepository autokRepository;
    @Autowired
    private ITipusRepository tipusRepository;
    @Autowired
    private IUgyfelekRepository ugyfelekRepository;
    @Autowired
    private IRendelesRepository rendelesRepository;

    @GetMapping("getAlkalmazottak")
    public List<AlkalmazottDTO> getAlkalmazottak() {
        List<Alkalmazott> alkalmazott = alkalmazottRepository.findAll();
        return AlkalmazottMapper.MAPPER.fromAlkalmazott(alkalmazott);
    }

    @GetMapping("getAutok")
    public List<AutokDTO> getAutok() {
        List<Autok> autok = autokRepository.findAll();
        return AutokMapper.MAPPER.fromAutok(autok);
    }
    @GetMapping("getRendelesek")
    public List<RendelesDTO> getRendeles() {
        List<Rendeles> rendeles = rendelesRepository.findAll();
        return RendelesMapper.MAPPER.fromRendeles(rendeles);
    }
    @GetMapping("getUgyfelek")
    public List<UgyfelekDTO> getUgyfelek() {
        List<Ugyfelek> ugyfelek = ugyfelekRepository.findAll();
        return UgyfelekMapper.MAPPER.fromUgyfelek(ugyfelek);
    }
    @GetMapping("getAutoCsop")
    public List<AutoCsopDTO> getAutoCsop(){
        List<AutoCsop> autoCsop= autoCsopRepository.findAll();
        return AutoCsopMapper.MAPPER.fromAutoCsop(autoCsop);
    }

    @GetMapping("getTipus")
    public List<TipusDTO> getTipus(){
        List<Tipus> tipus= tipusRepository.findAll();
        return TipusMapper.MAPPER.fromTipus(tipus);
    }
    @GetMapping("getReszleg")
    public List<Reszleg> getReszleg(){
        return reszlegRepository.findAll();
    }


}
