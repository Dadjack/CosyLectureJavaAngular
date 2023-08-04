package com.projet.library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "picture")
public class PictureEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false, length =50)
    private String name;

    @Column (nullable = false, length =50)
    private String url;

    @Column (nullable = false, length =255)
    private String description;

    @ManyToOne
    private LibraryUserEntity user;

    @ManyToOne
    private AuthorEntity author;

    @ManyToOne
    private BookEntity book;
}
