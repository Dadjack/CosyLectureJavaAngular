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
    // TODO : turn into current date after testing
    // When the borrow is created, the start date is set to the current date
    @Column(nullable = false)
    private LocalDateTime startDate;

    // When the borrow is created, the end date is set to the current date + 30 days
    @Column(nullable = false)
    private LocalDateTime endDate;

    // TODO : turn into current date after testing
    // When the borrow is returned, the return date is set to the current date
    @Column(nullable = false)
    private LocalDateTime returnDate;

    // When the borrow is created, the return statement is set to false
    private Boolean isReturned;

    private long borrowDuration;

    private long borrowDelay;

    private Float penalty;

    //Relationships
    @JsonIgnore
    @ManyToOne
    private LibraryUserEntity user;

    @JsonIgnore
    @ManyToOne
    private BookEntity book;


}
