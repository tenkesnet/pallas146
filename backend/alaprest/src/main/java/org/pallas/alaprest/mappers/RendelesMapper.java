package org.pallas.alaprest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pallas.alaprest.dtos.AutokDTO;
import org.pallas.alaprest.dtos.RendelesDTO;
import org.pallas.alaprest.model.Autok;
import org.pallas.alaprest.model.Rendeles;

import java.util.List;

@Mapper
public interface RendelesMapper {

    RendelesMapper MAPPER = Mappers.getMapper(RendelesMapper.class);

    @Mapping(target = "rendszam", source = "autok.rendszam")
    @Mapping(target = "autoTipus", source = "tipus.tipusNev")
    @Mapping(target = "ugyfelNev", source = "ugyfelek.ugyfelNev")
    RendelesDTO fromRendeles(Rendeles rendeles);
    List<RendelesDTO> fromRendeles(List<Rendeles> rendeles);

}
