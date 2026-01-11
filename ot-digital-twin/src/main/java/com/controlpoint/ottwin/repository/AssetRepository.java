package com.controlpoint.ottwin.repository;

import com.controlpoint.ottwin.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
