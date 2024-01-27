package org.vegyesbolt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vegyesbolt.models.Financial;

public interface IFinancialRepository extends JpaRepository<Financial, Integer> {

}
