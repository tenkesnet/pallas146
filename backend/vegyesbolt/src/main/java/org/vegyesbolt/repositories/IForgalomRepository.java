package org.vegyesbolt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vegyesbolt.models.Forgalom;

public interface IForgalomRepository extends JpaRepository<Forgalom, Integer> {

}
