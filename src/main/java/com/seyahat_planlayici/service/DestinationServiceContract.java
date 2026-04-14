package com.seyahat_planlayici.service;

import com.seyahat_planlayici.model.Destination;

import java.util.List;

public interface DestinationServiceContract {
    List<Destination> getAll();

    Destination getById(Long id);

    Destination save(Destination destination);

    void delete(Long id);

    List<Destination> getByCountry(String country);

    List<Destination> getByCategory(String category);

    List<Destination> getByBudget(Double budget);

    Destination update(Long id, Destination updated);

    List<Destination> search(String keyword);
}
