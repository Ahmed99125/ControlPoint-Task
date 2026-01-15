    package com.controlpoint.ottwin.service;

    import com.controlpoint.ottwin.dto.AssetDTO;
    import com.controlpoint.ottwin.dto.SensorReadingDTO;
    import com.controlpoint.ottwin.model.Asset;
    import com.controlpoint.ottwin.model.AssetStatus;
    import com.controlpoint.ottwin.model.SensorReading;
    import lombok.Data;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.scheduling.annotation.Scheduled;
    import org.springframework.stereotype.Service;

    import java.time.LocalDateTime;
    import java.util.List;
    import java.util.Random;

    @Service
    public class SimulationService {
        private final AssetService assetService;
        private final SensorService sensorService;

        private static final Double MIN_TEMP = 20.0;
        private static final Double MAX_TEMP = 150.0;
        private static final Double MIN_PRESSURE = 800.0;
        private static final Double MAX_PRESSURE = 1500.0;

        private final AssetStatus[] statuses = AssetStatus.values();
        private final Random random = new Random();

        @Autowired
        public SimulationService(AssetService assetService, SensorService sensorService) {
            this.assetService = assetService;
            this.sensorService = sensorService;
        }

        @Scheduled(fixedRate = 5000)
        public void simulateSensorData() {
            List<AssetDTO> assets = assetService.getAllAssets();

            for (AssetDTO assetDTO : assets) {
                Double newTemperature = MIN_TEMP + (MAX_TEMP - MIN_TEMP) * random.nextDouble();
                Double newPressure = MIN_PRESSURE + (MAX_PRESSURE - MIN_PRESSURE) * random.nextDouble();

                int statusIndex = random.nextInt(statuses.length);
                AssetStatus newStatus = statuses[statusIndex];

                AssetDTO updatedAssetDTO = new AssetDTO(
                        assetDTO.id(),
                        assetDTO.name(),
                        assetDTO.type(),
                        newStatus
                );
                assetService.saveAsset(updatedAssetDTO);

                SensorReadingDTO newSensorReadingDTO = new SensorReadingDTO(
                        null,
                        assetDTO.id(),
                        newTemperature,
                        newPressure,
                        LocalDateTime.now());

                sensorService.saveReading(newSensorReadingDTO);

                System.out.println("simulated sensor data for asset: " + updatedAssetDTO.id());
            }

        }
    }
