package com.projet.library.repositories;

import com.projet.library.entities.NationalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalityRepository extends JpaRepository<NationalityEntity, Integer> {
}
