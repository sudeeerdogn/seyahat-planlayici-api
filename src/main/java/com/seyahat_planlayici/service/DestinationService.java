package com.seyahat_planlayici.service;

import com.seyahat_planlayici.exception.ResourceNotFoundException;
import com.seyahat_planlayici.model.Destination;
import com.seyahat_planlayici.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService implements DestinationServiceContract {

    private final DestinationRepository repository;

    @Override
    public List<Destination> getAll() {
        return repository.findAll();
    }

    @Override
    public Destination getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destinasyon bulunamadı: " + id));
    }

    @Override
    public Destination save(Destination destination) {
        return repository.save(destination);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Destination> getByCountry(String country) {
        return repository.findByCountry(country);
    }

    @Override
    public List<Destination> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    @Override
    public List<Destination> getByBudget(Double budget) {
        return repository.findByEstimatedBudgetLessThanEqual(budget);
    }
    @Override
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
    @Override
    public List<Destination> search(String keyword) {
        return repository.search(keyword);
    }
}