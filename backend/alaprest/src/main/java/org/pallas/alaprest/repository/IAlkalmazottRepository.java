package org.pallas.alaprest.repository;

import org.pallas.alaprest.model.Alkalmazott;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlkalmazottRepository extends JpaRepository<Alkalmazott,Integer> {
}
