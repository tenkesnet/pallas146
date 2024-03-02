package org.pallas.alaprest.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.pallas.alaprest.dtos.AutoCsopDTO;
import org.pallas.alaprest.mappers.AutoCsopMapper;
import org.pallas.alaprest.model.AutoCsop;
import org.pallas.alaprest.repository.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelServiceTest {
    @InjectMocks
    ModelService modelService;

    @Mock
    private  IAutoCsopRepository autoCsopRepository;
    @Mock
    private  IAlkalmazottRepository alkalmazottRepository;
    @Mock
    private  IReszlegRepository reszlegRepository;
    @Mock
    private  IAutokRepository autokRepository;
    @Mock
    private  ITipusRepository tipusRepository;
    @Mock
    private  IUgyfelekRepository ugyfelekRepository;
    @Mock
    private  IRendelesRepository rendelesRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void getAutoCsopTest(){
        //Given
        AutoCsop a1 = new AutoCsop();
        AutoCsop a2 = new AutoCsop();
        List<AutoCsop> autoCsopok = new ArrayList<>();
        autoCsopok.add(a1);
        autoCsopok.add(a2);

        //When
        Mockito.when(autoCsopRepository.findAll()).thenReturn(autoCsopok);
        List<AutoCsopDTO> autoCsops =  modelService.getAutoCsop();

        //then
        assertEquals(autoCsopok.size(), autoCsops.size());
    }
}