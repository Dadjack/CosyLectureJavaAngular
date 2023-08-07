package com.projet.library.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.library.entities.BookEntity;
//import com.projet.library.entities.CategoryEntity;

public interface BookRepository extends JpaRepository <BookEntity, Integer>  {
    
    List<BookEntity> findByTitle(String title);
    // List<BookEntity> findByAuthor(String author);
    // List<BookEntity> findByCategory(CategoryEntity category);
}
