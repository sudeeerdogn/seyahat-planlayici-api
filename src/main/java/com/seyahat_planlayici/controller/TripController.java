package com.seyahat_planlayici.controller;

import com.seyahat_planlayici.model.Trip;
import com.seyahat_planlayici.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService service;

    @GetMapping
    public List<Trip> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Trip> create(@RequestBody Trip trip) {
        return ResponseEntity.ok(service.save(trip));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/destination/{destinationId}")
    public List<Trip> getByDestination(@PathVariable Long destinationId) {
        return service.getByDestination(destinationId);
    }
}