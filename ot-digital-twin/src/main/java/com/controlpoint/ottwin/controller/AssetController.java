package com.controlpoint.ottwin.controller;

import com.controlpoint.ottwin.dto.AssetDTO;
import com.controlpoint.ottwin.dto.SensorReadingDTO;
import com.controlpoint.ottwin.model.Asset;
import com.controlpoint.ottwin.model.SensorReading;
import com.controlpoint.ottwin.service.AssetService;
import com.controlpoint.ottwin.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AssetDTO> createAsset(@RequestBody AssetDTO assetDTO) {
        assetDTO = assetService.saveAsset(assetDTO);
        return ResponseEntity.ok(assetDTO);
    }

    @GetMapping
    public ResponseEntity<List<AssetDTO>> getAllAssets() {
        return ResponseEntity.ok(assetService.getAllAssets());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AssetDTO> getAssetById(@PathVariable long id) {
        return assetService.getAssetById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/readings/latest")
    public ResponseEntity<SensorReadingDTO> getLatestReading(@PathVariable long id) {
        return  sensorService.getLatestReading(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
