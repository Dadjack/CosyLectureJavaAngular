package com.projet.library.entities;


import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libraryUser")
public class LibraryUserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 50)
    private String firstName;

    @Column(nullable = false,length = 50)
    private String lastName;

    @Column(nullable = false,length = 200)
    private String password;

    @Column(nullable = false,length = 50)
    private String email;

    @Column(nullable = false)
    private LocalDateTime birthday;

    @Column(length = 200)
    private String picture;

    @Column(length = 50)
    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    private RoleEntity role;

    @OneToMany(mappedBy = "user")
    public Collection<BorrowEntity> borrows;
    
}
