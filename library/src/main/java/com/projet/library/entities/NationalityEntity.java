package com.projet.library.entities;

import com.projet.library.repositories.NationalityRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
public class NationalityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    //Relationships
    @ManyToMany
    private Collection <AuthorEntity> authorCollection;

    public static Collection<NationalityEntity> randomNationalities(NationalityRepository nationalityRepository) {
        return nationalityRepository.findAll();
    }
}
