package org.vegyesbolt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vegyesbolt.models.Termekek;

public interface ITermekekRepository extends JpaRepository<Termekek, Integer> {

}
