package org.pallas.alaprest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.pallas.alaprest.dtos.AutoCsopDTO;
import org.pallas.alaprest.dtos.TipusDTO;
import org.pallas.alaprest.model.AutoCsop;
import org.pallas.alaprest.model.Tipus;

import java.util.List;

@Mapper
public interface TipusMapper {
    TipusMapper MAPPER = Mappers.getMapper(TipusMapper.class);

    @Mapping(target = "kivitel", source = "leiras")
    TipusDTO fromTipus(Tipus tipus);
    List<TipusDTO> fromTipus(List<Tipus> tipus);
}
