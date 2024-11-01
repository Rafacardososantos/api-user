package com.example.api_user.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

}
