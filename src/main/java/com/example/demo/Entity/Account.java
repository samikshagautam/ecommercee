package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first")
    private String firstName;
    @Column(name = "last")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
