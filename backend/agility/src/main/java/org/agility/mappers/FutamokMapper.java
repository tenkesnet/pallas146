package org.agility.mappers;

import org.agility.dtos.FutamokDTO;
import org.agility.dtos.KutyasokDTO;
import org.agility.models.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.text.DateFormatSymbols;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Mapper
public interface FutamokMapper {

    FutamokMapper MAPPER= Mappers.getMapper(FutamokMapper.class);

    @Mapping(target = "felvezetonev", source = "kutyasok.teljesnev")
    @Mapping(target ="kutyanev", source = "kutyak.hivonev")
    @Mapping(target ="helyezes", source = "eredmeny")
    FutamokDTO fromFutamok(Futamok futamok);
    List<FutamokDTO> fromFutamok(List<Futamok> futamok);


    @AfterMapping
    default void setEletkor(@MappingTarget FutamokDTO dtoEletkor, Futamok futamok){
    Kutyasok kutyasok=futamok.getKutyasok();
        Calendar cal = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        cal.setTime(kutyasok.getSzuldat());
        //dto.setFelvezetoKor(now.get(Calendar.YEAR)-cal.get(Calendar.YEAR));
        if (now.get(Calendar.DAY_OF_YEAR) < cal.get(Calendar.DAY_OF_YEAR)) {
            dtoEletkor.setFelvezetoKor(now.get(Calendar.YEAR) - cal.get(Calendar.YEAR) - 1);
        } else {
            dtoEletkor.setFelvezetoKor(now.get(Calendar.YEAR) - cal.get(Calendar.YEAR));
        }
    }
    @AfterMapping
    default void setMeretkat(@MappingTarget FutamokDTO dtoMeret, Futamok futamokMeret){
        Meretkategoria meretkategoria=futamokMeret.getKutyak().getMeretkategoria();
        dtoMeret.setMeret(meretkategoria.getMeret());
    }
    @AfterMapping
    default void setSzintkat(@MappingTarget FutamokDTO dtoSzint, Futamok futamokSzint){
        Szintkategoria szintkategoria=futamokSzint.getKutyak().getSzintkategoria();
        dtoSzint.setSzint(szintkategoria.getSzint());
    }
    @AfterMapping
    default void setFajta(@MappingTarget FutamokDTO dtoFajta, Futamok futamokFajta){
        Kutyafajtak fajta=futamokFajta.getKutyak().getKutyafajtak();
        dtoFajta.setFajta(fajta.getKutyafajta());
    }
    @AfterMapping
    default void setNap(@MappingTarget FutamokDTO dtoNap, Futamok futamokNap) {
        Calendar cal = Calendar.getInstance();
        String[] napok= new DateFormatSymbols().getWeekdays();
        Date date = Date.from(futamokNap.getKezdoIdopont().atZone(ZoneId.systemDefault()).toInstant());
        cal.setTime(date);
        dtoNap.setVersenynap(napok[(cal.get(Calendar.DAY_OF_WEEK))]);
    }
}
