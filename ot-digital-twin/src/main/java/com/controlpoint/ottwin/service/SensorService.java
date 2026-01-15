package com.controlpoint.ottwin.service;

import com.controlpoint.ottwin.dto.SensorReadingDTO;
import com.controlpoint.ottwin.mapper.SensorReadingMapper;
import com.controlpoint.ottwin.model.Asset;
import com.controlpoint.ottwin.model.SensorReading;
import com.controlpoint.ottwin.repository.AssetRepository;
import com.controlpoint.ottwin.repository.SensorReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorService {
    private final SensorReadingRepository sensorReadingRepository;
    private final AssetRepository assetRepository; // Needed to look up the Asset
    private final   SensorReadingMapper sensorReadingMapper;

    @Autowired
    public SensorService(SensorReadingRepository sensorReadingRepository,
                         AssetRepository assetRepository,
                         SensorReadingMapper sensorReadingMapper) {
        this.sensorReadingRepository = sensorReadingRepository;
        this.assetRepository = assetRepository;
        this.sensorReadingMapper = sensorReadingMapper;
    }

    public Optional<SensorReadingDTO> getLatestReading(Long assetId) {
        return sensorReadingRepository.findTopByAssetIdOrderByTimestampDesc(assetId)
                .map(sensorReadingMapper::toDTO);
    }

    public SensorReadingDTO saveReading(SensorReadingDTO readingDTO) {
        Asset asset = assetRepository.findById(readingDTO.assetId())
                .orElseThrow(() -> new RuntimeException("Asset not found with ID: " + readingDTO.assetId()));

        SensorReading reading = sensorReadingMapper.toEntity(readingDTO, asset);
        SensorReading savedReading = sensorReadingRepository.save(reading);

        return sensorReadingMapper.toDTO(savedReading);
    }
}
