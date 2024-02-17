package org.pallas.alaprest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.pallas.alaprest.dtos.AutokDTO;
import org.pallas.alaprest.dtos.UgyfelekDTO;
import org.pallas.alaprest.model.Autok;
import org.pallas.alaprest.model.Ugyfelek;

import java.util.List;

@Mapper
public interface UgyfelekMapper {
    UgyfelekMapper MAPPER = Mappers.getMapper(UgyfelekMapper.class);

    UgyfelekDTO fromUgyfelek(Ugyfelek ugyfelek);
    List<UgyfelekDTO> fromUgyfelek(List<Ugyfelek> ugyfelek);
}
