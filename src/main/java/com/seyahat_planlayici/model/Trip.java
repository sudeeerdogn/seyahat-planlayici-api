package com.seyahat_planlayici.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Trip adı boş olamaz")
    private String name;

    @NotNull(message = "Başlangıç tarihi boş olamaz")
    @FutureOrPresent(message = "Başlangıç tarihi geçmişte olamaz")
    private LocalDate startDate;

    @NotNull(message = "Bitiş tarihi boş olamaz")
    @Future(message = "Bitiş tarihi gelecekte olmalı")
    private LocalDate endDate;

    @NotNull(message = "Kişi sayısı boş olamaz")
    @Min(value = 1, message = "En az 1 kişi olmalı")
    private Integer personCount;

    private String notes;

    @NotNull(message = "Destinasyon seçilmeli")
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    public Double getTotalBudget() {
        if (destination != null && personCount != null) {
            return destination.getEstimatedBudget() * personCount;
        }
        return 0.0;
    }
}