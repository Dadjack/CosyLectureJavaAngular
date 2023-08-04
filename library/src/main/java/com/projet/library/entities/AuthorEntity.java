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

    //Relations
    // MappedBy id de l'auteur sert de de référence pour récupérer sa collection de livres
    @OneToMany(mappedBy = "author")
<<<<<<< HEAD
    public Collection<BookEntity> book;
=======
    public Collection<BookEntity> bookCollection;

    @OneToMany(mappedBy = "author")
    private Collection<PictureEntity> pictureCollection;

    @ManyToMany
    private Collection<NationalityEntity> nationalityCollection;
>>>>>>> 35b4829f087c538b7ee93d291a789d245b60a9af
}
