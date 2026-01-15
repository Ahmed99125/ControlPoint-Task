package com.controlpoint.ottwin;

import com.controlpoint.ottwin.model.Asset;
import com.controlpoint.ottwin.model.AssetStatus;
import com.controlpoint.ottwin.model.AssetType;
import com.controlpoint.ottwin.repository.AssetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner initDatabase(AssetRepository assetRepository) {
        return args -> {
            if (assetRepository.count() == 0) {
                System.out.println("Loading initial assets...");

                Asset pump = new Asset("Cooling Pump A", AssetType.PUMP, AssetStatus.STOPPED);

                Asset motor = new Asset("Conveyor Motor", AssetType.MOTOR, AssetStatus.RUNNING);

                Asset conveyor = new Asset("Main Belt", AssetType.CONVEYOR, AssetStatus.STOPPED);

                assetRepository.saveAll(List.of(pump, motor, conveyor));

                System.out.println("Data has been loaded: 3 assets created.");
            }
        };
    }
}
