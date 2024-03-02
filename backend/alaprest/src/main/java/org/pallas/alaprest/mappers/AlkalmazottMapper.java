package org.pallas.alaprest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pallas.alaprest.dtos.AlkalmazottResponseDTO;
import org.pallas.alaprest.model.Alkalmazott;

import java.util.List;

@Mapper
public interface AlkalmazottMapper {
    AlkalmazottMapper MAPPER = Mappers.getMapper(AlkalmazottMapper.class);
    @Mapping(target = "nev", source = "alkNev")
    @Mapping(target = "reszlegNev", source = "reszleg.reszlegNev")
    AlkalmazottResponseDTO fromAlkalmazott(Alkalmazott alkalmazott);

    List<AlkalmazottResponseDTO> fromAlkalmazott(List<Alkalmazott> alkalmazott);
}
