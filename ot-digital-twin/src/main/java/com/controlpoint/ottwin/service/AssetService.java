package com.controlpoint.ottwin.service;

import com.controlpoint.ottwin.dto.AssetDTO;
import com.controlpoint.ottwin.mapper.AssetMapper;
import com.controlpoint.ottwin.model.Asset;
import com.controlpoint.ottwin.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    @Autowired
    public AssetService(AssetRepository assetRepository,  AssetMapper assetMapper) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
    }

    public List<AssetDTO> getAllAssets() {
        return assetRepository.findAll()
                .stream()
                .map(assetMapper::toDTO)
                .toList();
    }

    public Optional<AssetDTO> getAssetById(Long assetId) {
        return assetRepository.findById(assetId)
                .map(assetMapper::toDTO);
    }

    public AssetDTO saveAsset(AssetDTO assetDTO) {
        Asset asset = assetMapper.toEntity(assetDTO);
        asset = assetRepository.save(asset);
        return assetMapper.toDTO(asset);
    }
}
