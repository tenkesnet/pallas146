package org.pallas.alaprest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pallas.alaprest.dtos.AlkalmazottDTO;
import org.pallas.alaprest.model.Alkalmazott;

import java.util.List;

@Mapper
public interface AlkalmazottMapper {
    AlkalmazottMapper MAPPER = Mappers.getMapper(AlkalmazottMapper.class);
    @Mapping(target = "nev", source = "alkNev")
    @Mapping(target = "reszlegNev", source = "reszleg.reszlegNev")
    AlkalmazottDTO fromAlkalmazott(Alkalmazott alkalmazott);

    List<AlkalmazottDTO> fromAlkalmazott(List<Alkalmazott> alkalmazott);
}
