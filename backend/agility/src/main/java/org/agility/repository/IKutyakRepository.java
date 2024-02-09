package org.agility.repository;

import org.agility.dtos.KutyakDTO;
import org.agility.models.Kutyak;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IKutyakRepository extends JpaRepository<Kutyak,Integer> {


    List<Kutyak> findByMeretkategoriaMeret(String meret);
}
