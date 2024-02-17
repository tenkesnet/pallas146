package org.pallas.alaprest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pallas.alaprest.dtos.AutoCsopDTO;
import org.pallas.alaprest.dtos.AutoCsopRequestDTO;
import org.pallas.alaprest.model.AutoCsop;

import java.util.List;

@Mapper
public interface AutoCsopRequestMapper {
    AutoCsopRequestMapper MAPPER = Mappers.getMapper(AutoCsopRequestMapper.class);
    @Mapping(target = "csoportNev", source = "autoCsopNev")
    AutoCsopDTO fromAutoCsop(AutoCsop autoCsop);
    List<AutoCsopDTO> fromAutoCsop(List<AutoCsop> autoCsop);
    @Mapping(source = "csoportNev", target = "autoCsopNev")
    AutoCsop toAutoCsop(AutoCsopRequestDTO autoCsopRequestDTO);

}
