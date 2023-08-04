package com.projet.library.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String summary;

    private Boolean available;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(nullable = false , length = 50)
    private String editor;

    @Column(nullable = false , length = 50)
    private String publicationYear;

    @Column(length = 50)
    private String version;

    @Column(length = 200 , nullable = false)
    private String picture;

    @OneToMany(mappedBy = "book")
    public Collection<BorrowEntity> borrowCollection;

    @ManyToOne
    private AuthorEntity author;

    @ManyToOne
    private CategoryEntity category;

}
