package com.example.Spring.Ecommerce.Project.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

//table admin
@Data
@Entity
@Table(name = "admin", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "time")
    Timestamp timestamp;
}
