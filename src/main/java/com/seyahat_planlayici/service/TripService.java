package com.seyahat_planlayici.service;

import com.seyahat_planlayici.exception.ResourceNotFoundException;
import com.seyahat_planlayici.model.Trip;
import com.seyahat_planlayici.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService implements TripServiceContract {

    private final TripRepository repository;
    private final DestinationService destinationService;

    @Override
    public List<Trip> getAll() {
        return repository.findAll();
    }

    @Override
    public Trip getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trip bulunamadı: " + id));
    }

    @Override
    public Trip save(Trip trip) {
        if (trip.getDestination() != null && trip.getDestination().getId() != null) {
            var destination = destinationService.getById(trip.getDestination().getId());
            trip.setDestination(destination);
        }
        return repository.save(trip);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Trip> getByDestination(Long destinationId) {
        return repository.findByDestinationId(destinationId);
    }
}