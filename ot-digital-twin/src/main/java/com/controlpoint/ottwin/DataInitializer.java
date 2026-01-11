package com.controlpoint.ottwin;

import com.controlpoint.ottwin.model.Asset;
import com.controlpoint.ottwin.model.AssetStatus;
import com.controlpoint.ottwin.model.AssetType;
import com.controlpoint.ottwin.service.AssetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner initDatabase(AssetService assetService) {
        return args -> {
            if (assetService.getAllAssets().isEmpty()) {
                System.out.println("Loading initial assets...");

                Asset pump = new Asset("Cooling Pump A", AssetType.PUMP, AssetStatus.STOPPED);
                assetService.saveAsset(pump);

                Asset motor = new Asset("Conveyor Motor", AssetType.MOTOR, AssetStatus.RUNNING);
                assetService.saveAsset(motor);

                Asset conveyor = new Asset("Main Belt", AssetType.CONVEYOR, AssetStatus.STOPPED);
                assetService.saveAsset(conveyor);

                System.out.println("Data has been loaded: 3 assets created.");
            }
        };
    }
}
