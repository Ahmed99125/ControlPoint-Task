package com.controlpoint.ottwin.mapper;

import com.controlpoint.ottwin.dto.AssetDTO;
import com.controlpoint.ottwin.model.Asset;
import org.springframework.stereotype.Component;

@Component
public class AssetMapper {
    public AssetDTO toDTO(Asset asset) {
        if (asset == null) return null;

        return new AssetDTO(asset.getId(), asset.getName(), asset.getType(), asset.getStatus());
    }

    public Asset toEntity(AssetDTO assetDTO) {
        if (assetDTO == null) return null;

        Asset asset = new Asset(
                assetDTO.name(),
                assetDTO.type(),
                assetDTO.status()
        );

        if (assetDTO.id() != null) asset.setId(assetDTO.id());

        return asset;
    }
}
