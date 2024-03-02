package org.pallas.alaprest.services;

import org.pallas.alaprest.dtos.*;
import org.pallas.alaprest.mappers.*;
import org.pallas.alaprest.model.*;
import org.pallas.alaprest.repository.*;
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
    public List<AlkalmazottResponseDTO> getAlkalmazottak() {
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

    public List<AutoCsopDTO> addAutoCsop(AutoCsopRequestDTO autoCsopRequestDTO){
        AutoCsop autoCsop = AutoCsopRequestMapper.MAPPER.toAutoCsop(autoCsopRequestDTO);
        autoCsopRepository.save(autoCsop);
        List<AutoCsop> autoCsops = autoCsopRepository.findAll();
        return AutoCsopMapper.MAPPER.fromAutoCsop(autoCsops);
    }

    public List<AlkalmazottResponseDTO> addAlkalmazott(AlkalmazottRequestDTO alkalmazottRequestDTO){
        Alkalmazott alkalmazott = AlkalmazottRequestMapper.MAPPER.toAlkalmazott(alkalmazottRequestDTO);

        Reszleg reszleg = reszlegRepository.findByReszlegNev(alkalmazott.getReszleg().getReszlegNev());
        alkalmazott.setReszleg(reszleg);
        alkalmazottRepository.save(alkalmazott);
        List<Alkalmazott> alkalmazotts = alkalmazottRepository.findAll();
        return AlkalmazottMapper.MAPPER.fromAlkalmazott(alkalmazotts);
    }
}
