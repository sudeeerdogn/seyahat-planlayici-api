package com.seyahat_planlayici.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Email bos olamaz")
        @Email(message = "Gecerli bir email giriniz")
        String email,
        @NotBlank(message = "Sifre bos olamaz")
        String password
) {
}
