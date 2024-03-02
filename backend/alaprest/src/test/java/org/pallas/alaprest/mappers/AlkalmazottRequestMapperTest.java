package org.pallas.alaprest.mappers;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pallas.alaprest.dtos.AlkalmazottDTO;
import org.pallas.alaprest.model.Alkalmazott;
import org.pallas.alaprest.model.Autok;
import org.pallas.alaprest.model.Reszleg;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlkalmazottRequestMapperTest {

    @Test
    public void alkalmazottToDTOTest_AllNullReferences() {
        //Given
        Alkalmazott alkalmazott = new Alkalmazott(
                1,
                23,
                "Róbert",
                "főnök",23000,4000,null,null,null);
        //When
        AlkalmazottDTO alkalmazottDTO = AlkalmazottRequestMapper.MAPPER.fromAlkalmazott(alkalmazott);

        //Then
        assertEquals(alkalmazott.getAlkNev(), alkalmazottDTO.getNev());
        assertEquals(alkalmazott.getBeosztas(), alkalmazottDTO.getBeosztas());
        assertEquals(null, alkalmazottDTO.getReszlegNev());
        assertEquals(alkalmazott.getFizetes(), alkalmazottDTO.getFizetes());
        assertEquals(alkalmazott.getPremium(), alkalmazottDTO.getPremium());
        assertEquals(alkalmazott.getBelepes(), null);
    }

    @Test
    public void alkalmazottToDTOTest_AllNonNullReferences() {
        //Given
        Reszleg reszleg = new Reszleg();
        reszleg.setReszlegNev("Központ");
        List<Autok> autok = new ArrayList<>();
        Alkalmazott alkalmazott = new Alkalmazott(
                1,
                23,
                "Róbert",
                "főnök",23000,4000, LocalDate.parse("2016-02-13"),
                reszleg,
                autok);
        //When
        AlkalmazottDTO alkalmazottDTO = AlkalmazottRequestMapper.MAPPER.fromAlkalmazott(alkalmazott);
        //Then
        assertEquals(alkalmazott.getAlkNev(), alkalmazottDTO.getNev());
        assertEquals(alkalmazott.getBeosztas(), alkalmazottDTO.getBeosztas());
        assertEquals(alkalmazott.getReszleg().getReszlegNev(), alkalmazottDTO.getReszlegNev());
        assertEquals(alkalmazott.getFizetes(), alkalmazottDTO.getFizetes());
        assertEquals(alkalmazott.getPremium(), alkalmazottDTO.getPremium());
        assertEquals(alkalmazott.getBelepes(), LocalDate.of(2016,2,13));
    }

    @Test
    void toAlkalmazott() {
    }
}