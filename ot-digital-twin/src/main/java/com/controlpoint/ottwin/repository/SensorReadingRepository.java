package com.controlpoint.ottwin.repository;

import com.controlpoint.ottwin.model.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorReadingRepository extends JpaRepository<SensorReading,Long> {
    // Finds the most recent reading for a specific asset
    Optional<SensorReading> findTopByAssetIdOrderByTimestampDesc(Long assetId);
}
