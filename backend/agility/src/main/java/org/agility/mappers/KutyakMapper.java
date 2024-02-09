package org.agility.mappers;

import org.agility.dtos.KutyakDTO;
import org.agility.models.Kutyak;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface KutyakMapper {
    KutyakMapper MAPPER= Mappers.getMapper(KutyakMapper.class);
    public List<KutyakDTO> fromKutyak(List<Kutyak> kutyak);
}
