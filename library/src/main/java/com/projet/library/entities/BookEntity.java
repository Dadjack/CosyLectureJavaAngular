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
    private Integer idBook;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "summary", nullable = false, columnDefinition = "TEXT")
    private String summary;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(nullable = false , length = 50)
    private String editor;

    @Column(nullable = false , length = 50)
    private String publicationYear;

    @Column(length = 50)
    private String version;

    @OneToMany(mappedBy = "book")
    public Collection<BorrowEntity> borrows;

    @OneToMany(mappedBy = "book")
    private AuthorEntity author;

    @ManyToOne
    private CategoryEntity category;
}
