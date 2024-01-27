package org.vegyesbolt.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.vegyesbolt.dtos.TermekekBaseDTO;
import org.vegyesbolt.models.Termekek;

import java.util.List;

@Mapper
public interface TermekekMapper {
    TermekekMapper MAPPER = Mappers.getMapper( TermekekMapper.class );
    List<TermekekBaseDTO> fromTermekek(List<Termekek> termekek);
}
