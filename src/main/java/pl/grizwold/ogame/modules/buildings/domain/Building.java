package pl.grizwold.ogame.modules.buildings.domain;

import lombok.Value;

@Value
public class Building {
    private int level;
    private BuildingType type;
    private String owner;
    private String planetId;
}
