package com.projet.library.repositories;
import com.projet.library.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {


}
