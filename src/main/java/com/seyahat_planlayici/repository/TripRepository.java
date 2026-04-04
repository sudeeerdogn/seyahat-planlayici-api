package com.seyahat_planlayici.repository;

import com.seyahat_planlayici.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByDestinationId(Long destinationId);
    List<Trip> findByPersonCountGreaterThanEqual(Integer personCount);
}