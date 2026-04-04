package com.seyahat_planlayici.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer personCount;
    private String notes;

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