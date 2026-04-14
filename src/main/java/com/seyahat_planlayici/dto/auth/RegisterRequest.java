package com.seyahat_planlayici.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "Isim bos olamaz")
        String name,
        @NotBlank(message = "Email bos olamaz")
        @Email(message = "Gecerli bir email giriniz")
        String email,
        @NotBlank(message = "Sifre bos olamaz")
        @Size(min = 6, message = "Sifre 6 harften kisa olamaz")
        String password
) {
}
