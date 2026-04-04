package com.seyahat_planlayici.controller;

import jakarta.validation.Valid;
import com.seyahat_planlayici.model.Destination;
import com.seyahat_planlayici.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService service;

    @GetMapping
    public List<Destination> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Destination> create(@Valid @RequestBody Destination destination) {
        return ResponseEntity.ok(service.save(destination));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/country/{country}")
    public List<Destination> getByCountry(@PathVariable String country) {
        return service.getByCountry(country);
    }

    @GetMapping("/category/{category}")
    public List<Destination> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/budget/{budget}")
    public List<Destination> getByBudget(@PathVariable Double budget) {
        return service.getByBudget(budget);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Destination> update(@PathVariable Long id, @Valid @RequestBody Destination destination) {
        return ResponseEntity.ok(service.update(id, destination));
    }
}