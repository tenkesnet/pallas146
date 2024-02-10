package org.retail.repositories;

import org.retail.models.Bolt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBoltRepository extends JpaRepository<Bolt,Integer> {
}
