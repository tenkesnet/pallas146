package org.retail.repositories;

import org.retail.models.Kozpont;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKozpontRepository extends JpaRepository<Kozpont,Integer> {
}
