package com.projet.library.repositories;

import com.projet.library.entities.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, Integer> {
}
