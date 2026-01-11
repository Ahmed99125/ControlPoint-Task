package com.controlpoint.ottwin.service;

import com.controlpoint.ottwin.model.SensorReading;
import com.controlpoint.ottwin.repository.SensorReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorService {
    private final SensorReadingRepository sensorReadingRepository;

    @Autowired
    public SensorService(SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }

    public Optional<SensorReading> getLatestReading(Long assetId) {
        return sensorReadingRepository.findTopByAssetIdOrderByTimestampDesc(assetId);
    }

    public SensorReading saveReading(SensorReading reading) {
        return sensorReadingRepository.save(reading);
    }
}
