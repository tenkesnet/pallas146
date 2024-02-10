package org.retail.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.retail.dtos.RaktarDTO;
import org.retail.models.Bolt;
import org.retail.models.Raktar;

import java.util.List;
@Mapper
public interface RaktarMapper {
    RaktarMapper MAPPER = Mappers.getMapper(RaktarMapper.class);

    RaktarDTO fromBolt(Raktar raktar);

    List<RaktarDTO> fromRaktar(List<Raktar> raktar);
}
