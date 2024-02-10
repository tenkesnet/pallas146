package org.retail.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.retail.dtos.RaktarDTO;
import org.retail.models.Bolt;
import org.retail.models.Raktar;

import java.util.List;

public interface RaktarMapper {
    RaktarMapper MAPPER = Mappers.getMapper(RaktarMapper.class);

    @Mapping(target = "boltNev", source = "bolt.bolt_nev")
    RaktarMapper fromBolt(Raktar raktar);

    List<RaktarDTO> fromRaktar(List<Raktar> raktar);
}
