package com.projet.library.entities;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    private RoleEntity role;

    @OneToMany(mappedBy = "user")
    public Collection<BorrowEntity> borrowCollection;

    @OneToMany(mappedBy = "user")
    private Collection<PictureEntity> pictureCollection;
}
