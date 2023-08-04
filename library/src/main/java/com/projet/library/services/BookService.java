package com.projet.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.library.entities.BookEntity;
import com.projet.library.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> searchByTitre(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<BookEntity> searchByAuteur(String author) {
        return bookRepository.findByAuthor(author);
    }

    // Ajoutez d'autres méthodes de recherche si nécessaire

}
