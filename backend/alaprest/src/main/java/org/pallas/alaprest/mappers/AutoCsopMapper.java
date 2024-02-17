package org.pallas.alaprest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pallas.alaprest.dtos.AutoCsopDTO;
import org.pallas.alaprest.dtos.AutokDTO;
import org.pallas.alaprest.model.AutoCsop;
import org.pallas.alaprest.model.Autok;

import java.util.List;

@Mapper
public interface AutoCsopMapper {
    AutoCsopMapper MAPPER = Mappers.getMapper(AutoCsopMapper.class);
    @Mapping(target = "csoportNev", source = "autoCsopNev")
    AutoCsopDTO fromAutoCsop(AutoCsop autoCsop);
    List<AutoCsopDTO> fromAutoCsop(List<AutoCsop> autoCsop);
}
