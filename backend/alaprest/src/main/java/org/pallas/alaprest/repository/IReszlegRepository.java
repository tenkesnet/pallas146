package org.pallas.alaprest.repository;

import org.pallas.alaprest.model.Reszleg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReszlegRepository extends JpaRepository<Reszleg,Integer> {
    Reszleg findByReszlegNev (String nev);
}
