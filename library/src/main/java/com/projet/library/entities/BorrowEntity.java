package com.projet.library.entities;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrow")
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
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



}
