package org.pallas.alaprest.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.pallas.alaprest.dtos.AlkalmazottDTO;
import org.pallas.alaprest.dtos.AlkalmazottRequestDTO;
import org.pallas.alaprest.model.Alkalmazott;

import java.util.List;

@Mapper
public interface AlkalmazottRequestMapper {
    AlkalmazottRequestMapper MAPPER = Mappers.getMapper(AlkalmazottRequestMapper.class);
    //@Mapping(target = "nev", source = "alkNev")
    @Mapping(target = "reszlegNev", source = "reszleg.reszlegNev")
    AlkalmazottDTO fromAlkalmazott(Alkalmazott alkalmazott);

    List<AlkalmazottDTO> fromAlkalmazott(List<Alkalmazott> alkalmazott);

    @Mapping(source = "nev", target = "alkNev")
    @Mapping(source = "reszlegNev", target = "reszleg.reszlegNev")
    @Mapping(target = "alkKod", source = "alkKod")
    Alkalmazott toAlkalmazott(AlkalmazottRequestDTO alkalmazottRequestDTO);

    @AfterMapping
    default void ChangeName(@MappingTarget AlkalmazottDTO alkalmazottDTO,Alkalmazott alkalmazott){
        alkalmazottDTO.setNev(alkalmazott.getAlkNev());
    }
}
