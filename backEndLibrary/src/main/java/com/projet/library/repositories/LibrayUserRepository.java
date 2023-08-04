package com.projet.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.library.entities.LibraryUserEntity;

public interface LibrayUserRepository extends JpaRepository<LibraryUserEntity, Integer> {
    
}
