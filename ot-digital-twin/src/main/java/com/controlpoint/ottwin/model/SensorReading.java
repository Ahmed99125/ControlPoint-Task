package com.controlpoint.ottwin.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class SensorReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    private Double temperature;
    private Double pressure;
    private LocalDateTime timestamp;

    public SensorReading(Asset asset, Double temperature, Double pressure, LocalDateTime timestamp) {
        this.asset = asset;
        this.temperature = temperature;
        this.pressure = pressure;
        this.timestamp = timestamp;
    }
}
