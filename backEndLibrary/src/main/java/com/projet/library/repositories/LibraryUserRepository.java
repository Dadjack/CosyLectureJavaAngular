package com.projet.library.repositories;

import com.projet.library.entities.LibraryUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryUserRepository extends JpaRepository<LibraryUserEntity, Integer> {
}
