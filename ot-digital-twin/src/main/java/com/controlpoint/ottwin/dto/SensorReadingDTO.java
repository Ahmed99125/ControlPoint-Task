package com.controlpoint.ottwin.dto;

import java.time.LocalDateTime;

public record SensorReadingDTO(
        Long id,
        Long assetId,
        double temperature,
        double pressure,
        LocalDateTime timestamp) {}
