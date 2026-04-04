package com.seyahat_planlayici.service;

import com.seyahat_planlayici.model.Destination;
import com.seyahat_planlayici.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository repository;

    public List<Destination> getAll() {
        return repository.findAll();
    }

    public Destination getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destinasyon bulunamadı: " + id));
    }

    public Destination save(Destination destination) {
        return repository.save(destination);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Destination> getByCountry(String country) {
        return repository.findByCountry(country);
    }

    public List<Destination> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Destination> getByBudget(Double budget) {
        return repository.findByEstimatedBudgetLessThanEqual(budget);
    }
    public Destination update(Long id, Destination updated) {
        Destination existing = getById(id);
        existing.setName(updated.getName());
        existing.setCountry(updated.getCountry());
        existing.setDescription(updated.getDescription());
        existing.setEstimatedBudget(updated.getEstimatedBudget());
        existing.setDurationDays(updated.getDurationDays());
        existing.setCategory(updated.getCategory());
        return repository.save(existing);
    }
    public List<Destination> search(String keyword) {
        return repository.search(keyword);
    }
}