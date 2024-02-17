package org.pallas.alaprest.services;

import org.pallas.alaprest.model.Tanulo;
import org.pallas.alaprest.repository.IAlkalmazottRepository;
import org.pallas.alaprest.repository.ITanuloRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

@Service
public class MyRestService {

    private final ITanuloRepository tanuloRepository;
    private final IAlkalmazottRepository alkalmazottRepository;

    public MyRestService(ITanuloRepository tanuloRepository, IAlkalmazottRepository alkalmazottRepository) {
        this.tanuloRepository = tanuloRepository;
        this.alkalmazottRepository = alkalmazottRepository;
    }

    public List<Tanulo> getTest3(String q, String from, String to){
        List<Tanulo> fiatalok = tanuloRepository.findAll();
        if (q == null && from == null && to == null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN);
            LocalDate date;
            try {
                date = LocalDate.parse("1980-01-01");
            } catch (DateTimeParseException e) {
                date = LocalDate.parse("1980-01-01");
            }
            fiatalok = tanuloRepository.findByBirthDateLessThan(date);
            return fiatalok;
        }
        if (q != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN);
            LocalDate start;
            LocalDate end;
            try {
                start = LocalDate.parse("1980-01-01");
                end = LocalDate.parse("1990-12-31");
            } catch (DateTimeParseException e) {
                start = LocalDate.parse("1980-01-01");
                end = LocalDate.parse("1990-12-31");
            }
            fiatalok = tanuloRepository.findByBirthDateBetween(start, end);
            return fiatalok;
        }
        if (from != null && to != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN);
            LocalDate fromDate;
            LocalDate toDate;
            try {
                fromDate = LocalDate.parse(from);
                toDate = LocalDate.parse(to);
            } catch (DateTimeParseException e) {
                fromDate = LocalDate.parse("1985-01-01");
                toDate = LocalDate.parse("2001-01-01");
            }
            fiatalok = tanuloRepository.findByBirthDateBetween(fromDate, toDate);
            return fiatalok;
        }
        return fiatalok;
    }
}
