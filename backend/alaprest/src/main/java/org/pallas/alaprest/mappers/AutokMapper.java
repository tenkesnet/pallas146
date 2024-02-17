package org.pallas.alaprest.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.pallas.alaprest.dtos.AutokDTO;
import org.pallas.alaprest.model.Autok;
import org.pallas.alaprest.model.Rendeles;
import org.pallas.alaprest.model.Tipus;

import java.util.List;

@Mapper
public interface AutokMapper {

    AutokMapper MAPPER = Mappers.getMapper(AutokMapper.class);

    @Mapping(target = "vetelAr", source = "ar")
    @Mapping(target = "alkalmazott", source = "alkalmazott.alkNev")
    @Mapping(target = "szervizKm", source = "tipus.szervizKm")
    AutokDTO fromAutok(Autok autok);
    List<AutokDTO> fromAutok(List<Autok> autok);

    @AfterMapping
    default void setMapper(@MappingTarget AutokDTO dto, Autok autok){
        Tipus tipus=autok.getTipus();
        int utSzervErtek = (autok.getUtSzerviz()!=null)?autok.getUtSzerviz():0;
        if((autok.getFutottKm() - utSzervErtek) > tipus.szervizKm){
            dto.setSzervizKoteles(true);
        }else {
            dto.setSzervizKoteles(false);
        }

    }



}
