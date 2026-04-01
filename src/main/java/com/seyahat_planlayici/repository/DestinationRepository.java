package com.seyahat_planlayici.repository;

import com.seyahat_planlayici.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByCountry(String country);
    List<Destination> findByCategory(String category);
    List<Destination> findByEstimatedBudgetLessThanEqual(Double budget);
}
