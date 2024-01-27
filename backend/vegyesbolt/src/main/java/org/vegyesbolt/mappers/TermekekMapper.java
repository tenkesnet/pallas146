package org.vegyesbolt.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.vegyesbolt.dtos.TermekekBaseDTO;
import org.vegyesbolt.models.Beszallitok;
import org.vegyesbolt.models.Termekek;

import java.util.List;

@Mapper
public interface TermekekMapper {
    TermekekMapper MAPPER = Mappers.getMapper( TermekekMapper.class );
    //@Mapping(target="beszallito", source="beszallitok.beszallitoMegnevezes")
    TermekekBaseDTO fromTermek(Termekek termekek);
    List<TermekekBaseDTO> fromTermekek(List<Termekek> termekek);

    @AfterMapping
    default void setBeszallito(@MappingTarget TermekekBaseDTO dto, Termekek termekek){
        Beszallitok beszallitok = termekek.getBeszallitok();
        dto.setBeszallito(beszallitok.getBeszallitoMegnevezes().toUpperCase());
    }

}
