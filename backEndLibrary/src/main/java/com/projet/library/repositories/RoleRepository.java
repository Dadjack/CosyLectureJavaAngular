package com.projet.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.library.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    
}
