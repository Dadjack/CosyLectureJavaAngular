package com.projet.library.entities;

import java.time.LocalDateTime;
import java.util.Collection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String firstname;

    @Column(length = 50, nullable = false)
    private String lastname;

    private LocalDateTime birthday;

    private LocalDateTime deathday;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(length = 50, nullable = false)
    private String nationality;

    @Column(length = 200 , nullable = false)
    private String picture;

    @OneToMany(mappedBy = "author")
    public Collection<BookEntity> book;

    @OneToMany(mappedBy = "author")
    private Collection<PictureEntity> pictures;

    @OneToMany(mappedBy ="author")
    private Collection<NationalityEntity> nationalities;
}
