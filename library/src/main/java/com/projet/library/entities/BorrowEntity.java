package com.projet.library.entities;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "borrow")
public class BorrowEntity {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "startDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "endDate", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "amount")
    private Float amount;

    @ManyToOne
    private LibraryUserEntity user;

    @ManyToOne
    private BookEntity book;


}
