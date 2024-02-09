package org.agility.mappers;

import org.agility.dtos.KutyasokDTO;
import org.agility.models.Kutyasok;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Calendar;
import java.util.List;

@Mapper
public interface KutyasokMapper {

    KutyasokMapper MAPPER = Mappers.getMapper(KutyasokMapper.class);

    @Mapping(target="szerepnev", source="szerep.nev")
    @Mapping(target = "szuldat", ignore = true)
    KutyasokDTO fromKutyasok(Kutyasok kutyasok);

    List<KutyasokDTO> fromKutyasok(List<Kutyasok> kutyasok);

    @AfterMapping
    default void setKutyasok(@MappingTarget KutyasokDTO dto, Kutyasok kutyasok){
        Calendar cal = Calendar.getInstance();
        cal.setTime(kutyasok.getSzuldat());
        dto.setSzuldat(cal.get(Calendar.YEAR));
    }


}
