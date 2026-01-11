package com.controlpoint.ottwin.service;

import com.controlpoint.ottwin.model.Asset;
import com.controlpoint.ottwin.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    private final AssetRepository assetRepository;

    @Autowired
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Optional<Asset> getAssetById(Long assetId) {
        return assetRepository.findById(assetId);
    }

    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }
}
