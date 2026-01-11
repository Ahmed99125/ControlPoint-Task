package com.controlpoint.ottwin.controller;

import com.controlpoint.ottwin.model.Asset;
import com.controlpoint.ottwin.model.SensorReading;
import com.controlpoint.ottwin.service.AssetService;
import com.controlpoint.ottwin.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assets")
@CrossOrigin(origins = "http://localhost:4200")
public class AssetController {
    private final AssetService assetService;
    private final SensorService sensorService;

    @Autowired
    public AssetController(AssetService assetService, SensorService sensorService) {
        this.assetService = assetService;
        this.sensorService = sensorService;
    }

    @PostMapping
    public Asset createAsset(@RequestBody Asset asset) {
        asset.setId(null);
        return assetService.saveAsset(asset);
    }

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }
    
    @GetMapping("/{id}")
    public Optional<Asset> getAssetById(@PathVariable long id) {
        return assetService.getAssetById(id);
    }

    @GetMapping("/{id}/readings/latest")
    public Optional<SensorReading> getLatestReading(@PathVariable long id) {
        return  sensorService.getLatestReading(id);
    }
}
