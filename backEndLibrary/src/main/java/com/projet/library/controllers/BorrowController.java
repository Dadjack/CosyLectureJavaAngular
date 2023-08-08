package com.projet.library.controllers;

import com.projet.library.entities.BorrowEntity;
import com.projet.library.repositories.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BorrowController {
    @Autowired
    BorrowRepository borrowRepository;

    @GetMapping("getAllBorrows")
    public ResponseEntity<Collection<BorrowEntity>> getAllBorrows() {
        return new ResponseEntity<>(borrowRepository.findAll(), HttpStatus.OK);
    }
}
