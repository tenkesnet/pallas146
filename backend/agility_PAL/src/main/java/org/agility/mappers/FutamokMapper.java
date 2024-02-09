package org.agility.mappers;

import org.agility.dtos.FutamokDTO;
import org.agility.models.Futamok;
import org.agility.models.Kutyak;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface FutamokMapper {
    FutamokMapper MAPPER = Mappers.getMapper(FutamokMapper.class);
    @Mapping(target = "meretkategoriaMeret", source = "kutyak.meretkat.meret")
    @Mapping(target = "szintNev", source = "kutyak.szintkat.szint")
    FutamokDTO fromMeretkat (Futamok meretkategoria);
    List<FutamokDTO> fromFutamok (List<Futamok> futamok2);


}
