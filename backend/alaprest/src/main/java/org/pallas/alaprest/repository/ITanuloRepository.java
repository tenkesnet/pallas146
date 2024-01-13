package org.pallas.alaprest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.pallas.alaprest.model.Tanulo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITanuloRepository extends JpaRepository<Tanulo,Integer> {
    List<Tanulo> findAllByOrderByIdAsc();
    List<Tanulo> findAllByOrderByIdDesc();

    List<Tanulo> findByHajSzin(String szin);
    List<Tanulo> findByBirthDate(LocalDate d);

    List<Tanulo> findByBirthDateLessThan(LocalDate t);

    List<Tanulo> findByBirthDateBetween(LocalDate start,LocalDate end);
}
