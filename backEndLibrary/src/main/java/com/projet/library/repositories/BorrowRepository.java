package com.projet.library.repositories;

import com.projet.library.entities.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BorrowRepository extends JpaRepository<BorrowEntity, Integer> {
}
