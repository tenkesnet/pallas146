package org.agility.repository;

import org.agility.dtos.KutyakDTO;
import org.agility.models.Kutyak;
import org.agility.models.Meretkategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMeretkategoriaRepository extends JpaRepository<Meretkategoria,Integer> {

    List<KutyakDTO> findByMeret(String meret);

}
