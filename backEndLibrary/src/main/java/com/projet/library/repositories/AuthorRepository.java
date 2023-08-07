package com.projet.library.repositories;
import com.projet.library.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
