package com.projet.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libraryuser", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class LibraryUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false)
    private LocalDateTime birthday;

    @Column(length = 50)
    private Integer phoneNumber;

    @Column(nullable = false)
    private String address;

    //Relationships
    @ManyToOne
    private RoleEntity role;

    @OneToMany(mappedBy = "user")
    public Collection<BorrowEntity> borrowCollection;

    @OneToMany(mappedBy = "user")
    private Collection<PictureEntity> pictureCollection;
}
