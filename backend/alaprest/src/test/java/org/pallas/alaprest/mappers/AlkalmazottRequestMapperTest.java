package org.pallas.alaprest.mappers;

import org.junit.jupiter.api.Test;
import org.pallas.alaprest.dtos.AlkalmazottResponseDTO;
import org.pallas.alaprest.dtos.AlkalmazottRequestDTO;
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
        AlkalmazottResponseDTO alkalmazottResponseDTO = AlkalmazottRequestMapper.MAPPER.fromAlkalmazott(alkalmazott);

        //Then
        assertEquals(alkalmazott.getAlkNev(), alkalmazottResponseDTO.getNev());
        assertEquals(2+3,5);
        assertEquals(alkalmazott.getBeosztas(), alkalmazottResponseDTO.getBeosztas());
        assertEquals(null, alkalmazottResponseDTO.getReszlegNev());
        assertEquals(alkalmazott.getFizetes(), alkalmazottResponseDTO.getFizetes());
        assertEquals(alkalmazott.getPremium(), alkalmazottResponseDTO.getPremium());
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
        AlkalmazottResponseDTO alkalmazottResponseDTO = AlkalmazottRequestMapper.MAPPER.fromAlkalmazott(alkalmazott);
        //Then
        assertEquals(alkalmazott.getAlkNev(), alkalmazottResponseDTO.getNev());
        assertEquals(alkalmazott.getBeosztas(), alkalmazottResponseDTO.getBeosztas());
        assertEquals(alkalmazott.getReszleg().getReszlegNev(), alkalmazottResponseDTO.getReszlegNev());
        assertEquals(alkalmazott.getFizetes(), alkalmazottResponseDTO.getFizetes());
        assertEquals(alkalmazott.getPremium(), alkalmazottResponseDTO.getPremium());
        assertEquals(alkalmazott.getBelepes(), LocalDate.of(2016,2,13));
    }

    @Test
    void FromDTOtoAlkalmazott() {
        //Given
        Reszleg reszleg = new Reszleg(0,23,"Szállítás","Pest",null);
        AlkalmazottRequestDTO alkalmazottDTO = new AlkalmazottRequestDTO(1,
                "Zoltán",
                "melós",
                40000,
                5000,LocalDate.parse("2018-12-21"),reszleg);
        //When
        Alkalmazott alkalmazott = AlkalmazottRequestMapper.MAPPER.toAlkalmazott(alkalmazottDTO);
        //Then
        assertEquals(alkalmazottDTO.getNev(),alkalmazott.getAlkNev());
        assertEquals(alkalmazottDTO.getReszleg().getReszlegNev(),alkalmazott.getReszleg().getReszlegNev());
    }
}