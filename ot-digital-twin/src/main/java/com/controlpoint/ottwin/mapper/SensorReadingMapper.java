package com.controlpoint.ottwin.mapper;

import com.controlpoint.ottwin.dto.SensorReadingDTO;
import com.controlpoint.ottwin.model.Asset;
import com.controlpoint.ottwin.model.SensorReading;
import org.springframework.stereotype.Component;

@Component
public class SensorReadingMapper {
    public SensorReadingDTO toDTO(SensorReading sensorReading) {
        if  (sensorReading == null) return null;

        Long assetId = (sensorReading.getAsset() != null) ? sensorReading.getAsset().getId() : null;

        return new SensorReadingDTO(
                sensorReading.getId(),
                assetId,
                sensorReading.getTemperature(),
                sensorReading.getPressure(),
                sensorReading.getTimestamp());
    }

    public SensorReading toEntity(SensorReadingDTO sensorReadingDTO, Asset asset) {
        if  (sensorReadingDTO == null) return null;

        return new SensorReading(
                asset,
                sensorReadingDTO.temperature(),
                sensorReadingDTO.pressure(),
                sensorReadingDTO.timestamp());
    }
}
