package com.example.Agility.controller;


import com.example.Agility.Repository.*;
import com.example.Agility.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping ("/agility")
public class AgilityController {
    @Autowired
    private ISzerepRepository szerepRepository;

    @GetMapping("getSzerep")
    public List<Szerep> getAll() {
        return szerepRepository.findAll();
    }

    @Autowired
    private IFutamokRepository futamokRepository;

    @GetMapping("getFutamok")
    public List<Futamok> getFutamok() {
        return futamokRepository.findAll();
    }

    @Autowired
    private IKutyasokRepository kutyasokRepository;

    @GetMapping("getKutyasok")
    public List<Kutyasok> getKutyasok() {
        return kutyasokRepository.findAll();
    }
    @Autowired
    private IKutyakRepository kutyakRepository;
    @GetMapping("getKutyak")
    public List<Kutyak> getKutyak(){
        return kutyakRepository.findAll();
    }
    @Autowired
    private IKutyafajtakRepository kutyafajtakRepository;
    @GetMapping("getKutyafajtak")
    public List<Kutyafajtak> getKutyafajtak(){
        return kutyafajtakRepository.findAll();
    }
    @Autowired
    private IMeretkategoriaRepository meretkategoriaRepository;
    @GetMapping("getMeretkategoria")
    public List<Meretkategoria> getMeretkategoria(){
        return meretkategoriaRepository.findAll();
    }
    @Autowired
    private ISzintkategoriaRepository szintkategoriaRepository;
    @GetMapping("getSzintkategoria")
    public List<Szintkategoria> getSzintkategoria(){
        return szintkategoriaRepository.findAll();
    }
}

