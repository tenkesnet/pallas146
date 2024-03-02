package org.pallas.alaprest.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pallas.alaprest.dtos.AlkalmazottDTO;
import org.pallas.alaprest.model.Alkalmazott;

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
    void testFromAlkalmazott() {
    }

    @Test
    void toAlkalmazott() {
    }
}