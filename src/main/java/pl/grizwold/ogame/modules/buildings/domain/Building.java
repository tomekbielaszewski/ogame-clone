package pl.grizwold.ogame.modules.buildings.domain;

import lombok.Value;

import java.math.BigInteger;

@Value
public class Building {
    private BigInteger level;
    private BuildingType type;
    private String owner;
    private String planetId;
}
