package com.controlpoint.ottwin.dto;

import com.controlpoint.ottwin.model.AssetStatus;
import com.controlpoint.ottwin.model.AssetType;

public record AssetDTO(Long id, String name, AssetType type, AssetStatus status) {}