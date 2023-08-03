package com.projet.library.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "author")
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", length = 50, nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

}
