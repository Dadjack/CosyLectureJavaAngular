package com.projet.library.entities;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    //private long duration;

    //private long delay;

    private Float penalty;

    //Relationships
    @JsonIgnore
    @ManyToOne
    private LibraryUserEntity user;

    @JsonIgnore
    @ManyToOne
    private BookEntity book;


}
