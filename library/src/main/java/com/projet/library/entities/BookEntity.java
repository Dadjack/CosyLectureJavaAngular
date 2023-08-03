package com.projet.library.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    @OneToMany(mappedBy = "book")
    public Collection<BorrowEntity> borrows;

    @OneToOne(mappedBy = "book")
    private AuthorEntity author;
}
