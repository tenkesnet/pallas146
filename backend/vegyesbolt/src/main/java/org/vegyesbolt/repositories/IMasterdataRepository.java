package org.vegyesbolt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vegyesbolt.models.Masterdata;

public interface IMasterdataRepository extends JpaRepository<Masterdata, Integer> {

}
