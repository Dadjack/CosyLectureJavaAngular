package com.projet.library.entities;

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
public class NationalityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @OneToMany(mappedBy ="nationalities")
    private Collection<AuthorEntity> author;

}
