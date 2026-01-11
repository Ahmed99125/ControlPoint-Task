package com.controlpoint.ottwin.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AssetType type;

    @Enumerated(EnumType.STRING)
    private AssetStatus status;

    public Asset(String name, AssetType type, AssetStatus status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }
}
