package com.seyahat_planlayici.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "destinations")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    private String description;
    private Double estimatedBudget;
    private Integer durationDays;
    private String category;
}