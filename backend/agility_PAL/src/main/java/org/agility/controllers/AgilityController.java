package org.agility.controllers;

import org.agility.dtos.FutamokDTO;
import org.agility.dtos.KutyasokBaseDTO;
import org.agility.mappers.FutamokMapper;
import org.agility.mappers.KutyasokMapper;
import org.agility.models.*;
import org.agility.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class AgilityController {
    @Autowired
    private IFutamokRepository futamokRepository;

    @Autowired
    private IKutyasokRepository kutyasokRepository;

    @Autowired
    private IKutyakRepository kutyakRepository;

    @Autowired
    private IKutyafajtakRepository kutyafajtakRepository;

    @Autowired
    private IMeretkategoriaRepository meretkategoriaRepository;

    @Autowired
    private ISzintkategoriaRepository szintkategoriaRepository;

    @Autowired
    private ISzerepRepository szerepRepository;

    @GetMapping("/getAll")
    public List<FutamokDTO> getFutamok2() {
        List<Futamok>futamok2 = futamokRepository.findAll();
        return FutamokMapper.MAPPER.fromFutamok(futamok2);
        /*return futamokRepository.findAll();*/
    }

    @GetMapping("/getKutyasok")
    public List<KutyasokBaseDTO> getKutyasok() {
        List<Kutyasok>kutyasok = kutyasokRepository.findAll();
        return KutyasokMapper.MAPPER.fromKutyasok(kutyasok);
        /*return kutyasokRepository.findAll();*/
    }

    @GetMapping("/getKutyak")
    public List<Kutyak> getKutyak() {

        return kutyakRepository.findAll();
    }

    @GetMapping("/getKutyafajtak")
    public List<Kutyafajtak> getKutyafajtak() {

        return kutyafajtakRepository.findAll();
    }

    @GetMapping("/getMeretkategoria")
    public List<Meretkategoria> getMeretkategoria() {

        return meretkategoriaRepository.findAll();
    }

    @GetMapping("/getSzintkategoria")
    public List<Szintkategoria> getSzintkategoria() {

        return szintkategoriaRepository.findAll();
    }

    @GetMapping("/getSzerep")
    public List<Szerep> getSzerep() {

        return szerepRepository.findAll();
    }
}
