package com.projet.library.controllers;

import com.projet.library.entities.LibraryUserEntity;
import com.projet.library.repositories.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/libraryUser")
public class LibraryUserController {
    @Autowired
    LibraryUserRepository libraryUserRepository;

    @GetMapping("getAllLibraryUsers")
    public ResponseEntity<Collection<LibraryUserEntity>> getAllLibraryUsers() {
        return new ResponseEntity<>(libraryUserRepository.findAll(), HttpStatus.OK);
    }
    
    //Method pour emprunter un 
}
