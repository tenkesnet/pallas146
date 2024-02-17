package org.pallas.alaprest.services;

import org.pallas.alaprest.dtos.*;
import org.pallas.alaprest.mappers.*;
import org.pallas.alaprest.model.*;
import org.pallas.alaprest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    private final IAutoCsopRepository autoCsopRepository;
    private final IAlkalmazottRepository alkalmazottRepository;
    private final IReszlegRepository reszlegRepository;

    private final IAutokRepository autokRepository;

    private final ITipusRepository tipusRepository;

    private final IUgyfelekRepository ugyfelekRepository;

    private final IRendelesRepository rendelesRepository;

    public ModelService(IAutoCsopRepository autoCsopRepository,
                        IAlkalmazottRepository alkalmazottRepository,
                        IReszlegRepository reszlegRepository,
                        IAutokRepository autokRepository,
                        ITipusRepository tipusRepository,
                        IUgyfelekRepository ugyfelekRepository,
                        IRendelesRepository rendelesRepository) {
        this.autoCsopRepository = autoCsopRepository;
        this.alkalmazottRepository = alkalmazottRepository;
        this.reszlegRepository = reszlegRepository;
        this.autokRepository = autokRepository;
        this.tipusRepository = tipusRepository;
        this.ugyfelekRepository = ugyfelekRepository;
        this.rendelesRepository = rendelesRepository;
    }


    public List<AutoCsopDTO> getAutoCsop(){
        List<AutoCsop> autoCsop= autoCsopRepository.findAll();
        return AutoCsopMapper.MAPPER.fromAutoCsop(autoCsop);
    }
    public List<AlkalmazottDTO> getAlkalmazottak() {
        List<Alkalmazott> alkalmazott = alkalmazottRepository.findAll();
        return AlkalmazottMapper.MAPPER.fromAlkalmazott(alkalmazott);
    }
    public List<AutokDTO> getAutok() {
        List<Autok> autok = autokRepository.findAll();
        return AutokMapper.MAPPER.fromAutok(autok);
    }
    public List<RendelesDTO> getRendeles() {
        List<Rendeles> rendeles = rendelesRepository.findAll();
        return RendelesMapper.MAPPER.fromRendeles(rendeles);
    }
    public List<UgyfelekDTO> getUgyfelek() {
        List<Ugyfelek> ugyfelek = ugyfelekRepository.findAll();
        return UgyfelekMapper.MAPPER.fromUgyfelek(ugyfelek);
    }
    public List<TipusDTO> getTipus(){
        List<Tipus> tipus= tipusRepository.findAll();
        return TipusMapper.MAPPER.fromTipus(tipus);
    }
    public List<Reszleg> getReszleg(){
        return reszlegRepository.findAll();
    }
}
