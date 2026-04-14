package com.seyahat_planlayici.service;

import com.seyahat_planlayici.model.Trip;

import java.util.List;

public interface TripServiceContract {
    List<Trip> getAll();

    Trip getById(Long id);

    Trip save(Trip trip);

    void delete(Long id);

    List<Trip> getByDestination(Long destinationId);
}
