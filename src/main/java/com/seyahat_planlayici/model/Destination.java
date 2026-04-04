package com.seyahat_planlayici.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "destinations")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Destinasyon adı boş olamaz")
    private String name;

    @NotBlank(message = "Ülke boş olamaz")
    private String country;

    private String description;

    @NotNull(message = "Bütçe boş olamaz")
    @Positive(message = "Bütçe pozitif olmalı")
    private Double estimatedBudget;

    @NotNull(message = "Gün sayısı boş olamaz")
    @Min(value = 1, message = "En az 1 gün olmalı")
    private Integer durationDays;

    private String category;
}