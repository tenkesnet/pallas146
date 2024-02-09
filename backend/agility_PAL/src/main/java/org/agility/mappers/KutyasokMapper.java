package org.agility.mappers;

import org.agility.dtos.KutyasokBaseDTO;

import org.agility.models.Kutyasok;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public interface KutyasokMapper {
    KutyasokMapper MAPPER = Mappers.getMapper( KutyasokMapper.class );
    @Mapping(target ="szerepNev", source="szerep.nev")
    @Mapping(target = "szuldat", ignore = true)
    KutyasokMapper fromKutya (Kutyasok kutyasok);
    List<KutyasokBaseDTO> fromKutyasok(List<Kutyasok> kutyasok);

    @AfterMapping
    default void setKutyasok(@MappingTarget KutyasokBaseDTO dto, Kutyasok kutyasok){
        Calendar cal = Calendar.getInstance();
        cal.setTime(kutyasok.getSzuldat());
        dto.setSzuldat(cal.get(Calendar.YEAR));
    }
}
