package com.seyahat_planlayici.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "İsim boş olamaz")
    private String name;

    @Email(message = "Geçerli bir email girin")
    @NotBlank(message = "Email boş olamaz")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Şifre boş olamaz")
    private String password;

    private String role = "USER";
}