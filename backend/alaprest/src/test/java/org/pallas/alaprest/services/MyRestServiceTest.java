package org.pallas.alaprest.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.pallas.alaprest.model.Tanulo;
import org.pallas.alaprest.repository.IAlkalmazottRepository;
import org.pallas.alaprest.repository.ITanuloRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MyRestServiceTest {
    @InjectMocks
    MyRestService myRestService;

    @Mock
    ITanuloRepository tanuloRepository;
    @Mock
    IAlkalmazottRepository alkalmazottRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTest3_IfAllNullParam() {
        //Given
        Tanulo t1= new Tanulo(1,"Andras", LocalDate.parse("1984-02-03"),87,"barna");
        Tanulo t2= new Tanulo(2,"Feri", LocalDate.parse("1974-02-03"),82,"barna");
        List<Tanulo> tlist = new ArrayList<>();
        tlist.add(t1);
        tlist.add(t2);

        //Mock the calls
        when(tanuloRepository.findAll()).thenReturn(tlist);
        when(tanuloRepository.findByBirthDateLessThan(any(LocalDate.class))).thenAnswer(i->{
            LocalDate argument = (LocalDate) i.getArguments()[0];
            LocalDate result=LocalDate.parse("1980-01-01");
            List<String> l1 = new ArrayList<>();
            if(argument.equals(result)) {
                l1.add("Hello");
            }
            return l1;
        });

        //When
        //List<Tanulo> tanulok = myRestService.getTest3(null, "1975-01-01", "1985-03-03");
        List<Tanulo> tanulok = myRestService.getTest3(null, null, null);
        //Then
        assertEquals(tanulok.size(), 1);
    }
    @Test
    void getTest3_IfQNotNull() {
        //Given
        Tanulo t1= new Tanulo(1,"Andras", LocalDate.parse("1984-02-03"),87,"barna");
        Tanulo t2= new Tanulo(2,"Feri", LocalDate.parse("1974-02-03"),82,"barna");
        List<Tanulo> tlist = new ArrayList<>();
        tlist.add(t1);
        tlist.add(t2);

        //Mock the calls
        when(tanuloRepository.findAll()).thenReturn(tlist);
        when(tanuloRepository.findByBirthDateBetween(any(LocalDate.class),any(LocalDate.class))).thenAnswer(i->{
            LocalDate from = (LocalDate) i.getArguments()[0];
            LocalDate to = (LocalDate) i.getArguments()[1];
            LocalDate fromParameter=LocalDate.parse("1980-01-01");
            LocalDate toParameter=LocalDate.parse("1990-12-31");
            List<String> l1 = new ArrayList<>();
            if(from.equals(fromParameter) && to.equals(toParameter)) {
                l1.add("Hello");
            }
            return l1;
        });

        //When
        //List<Tanulo> tanulok = myRestService.getTest3(null, "1975-01-01", "1985-03-03");
        List<Tanulo> tanulok = myRestService.getTest3("", null, null);
        //Then
        assertEquals(tanulok.size(), 1);
    }

    @Test
    void getTest3_IfOneToOrFromNotNullAndQIsNull() {
        //Given
        Tanulo t1= new Tanulo(1,"Andras", LocalDate.parse("1984-02-03"),87,"barna");
        Tanulo t2= new Tanulo(2,"Feri", LocalDate.parse("1974-02-03"),82,"barna");
        Tanulo t3= new Tanulo(3,"Anna", LocalDate.parse("1974-02-03"),82,"szoke");
        List<Tanulo> tlist = new ArrayList<>();
        tlist.add(t1);
        tlist.add(t2);
        tlist.add(t3);
        //Mock the calls
        when(tanuloRepository.findAll()).thenReturn(tlist);

        //When
        //List<Tanulo> tanulok = myRestService.getTest3(null, "1975-01-01", "1985-03-03");
        List<Tanulo> tanulok = myRestService.getTest3(null, "", null);
        //Then
        assertEquals(tlist.size(),tanulok.size());
    }
}