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
    private Integer idUser;

    @Column(name = "firstname", nullable = false,length = 50)
    private String firstName;

    @Column(name = "lastname", nullable = false,length = 50)
    private String lastName;

    @Column(name = "password", nullable = false,length = 200)
    private String password;

    @Column(name = "email", nullable = false,length = 50)
    private String email;

    @Column(name = "birthday", nullable = false)
    private LocalDateTime birthday;

    @Column(name = "picture", length = 200)
    private String picture;

    @Column(name = "phonenumber", length = 50)
    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="role") 
    private RoleEntity role;

    @OneToMany(mappedBy = "user")
    public Collection<BorrowEntity> borrows;


    // @ElementCollection(targetClass = Role.class, fetch=FetchType.EAGER)
    // @Enumerated(EnumType.STRING)
    // @CollectionTable(name="user_roles")
    // @Column(name="role") 
    // private Set<Role> roles;
    

    
}
