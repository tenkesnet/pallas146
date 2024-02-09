package org.agility.controllers;

import org.agility.dtos.FutamokDTO;
import org.agility.dtos.KutyakDTO;
import org.agility.mappers.FutamokMapper;
import org.agility.mappers.KutyakMapper;
import org.agility.mappers.KutyasokMapper;
import org.agility.dtos.KutyasokDTO;
import org.agility.models.*;
import org.agility.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AgilityController {

    @Autowired
    private ISzerepRepository szerepRepository;
    @Autowired
    private IFutamokRepository futamokRepository;
    @Autowired
    private IKutyakRepository kutyakRepository;
    @Autowired
    private IKutyasokRepository kutyasokRepository;
    @Autowired
    private IMeretkategoriaRepository meretkategoriaRepository;
    @Autowired
    private ISzintkategoriaRepository szintkategoriaRepository;
    @Autowired
    private IKutyafajtakRepository kutyafajtakRepository;

    @GetMapping("getSzerep")
    public List<Szerep> getSzerep(){
        return szerepRepository.findAll();
    }

    @GetMapping("getFutamok")
    public List<FutamokDTO> getFutamok(){
        List<Futamok> futamok =futamokRepository.findAll();
        return FutamokMapper.MAPPER.fromFutamok(futamok);
    }
   /*@GetMapping("getFutamok")
    public List<Futamok> getFutamok(){
    return futamokRepository.findAll();}*/

    @GetMapping("getKutyasok")
    public List<KutyasokDTO> getKutyasok(){
        List<Kutyasok> kutyasok = kutyasokRepository.findAll();
        return KutyasokMapper.MAPPER.fromKutyasok(kutyasok);
        //return kutyasokRepository.findAll();
    }

    @GetMapping("getKutyak")
    public List<Kutyak> getKutyak(){
        return kutyakRepository.findAll();
    }

    @GetMapping("getKutyafajtak")
    public List<Kutyafajtak> getKutyafajtak(){
        return kutyafajtakRepository.findAll();
    }

    @GetMapping("getSzintkategoria")
    public List<Szintkategoria> getSzintkategoria(){
        return szintkategoriaRepository.findAll();
    }

    @GetMapping("getMeretkategoria")
    public List<Meretkategoria> getMeretkategoria(){
        return meretkategoriaRepository.findAll();
    }

    @GetMapping("getMeret")
    public List<KutyakDTO> getKutyakMeret(@RequestParam(required = false) String meret){
        return KutyakMapper.MAPPER.fromKutyak(kutyakRepository.findByMeretkategoriaMeret(meret));
    }

}
