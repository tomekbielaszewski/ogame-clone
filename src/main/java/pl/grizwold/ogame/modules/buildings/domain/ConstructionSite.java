package pl.grizwold.ogame.modules.buildings.domain;

import lombok.Value;

import java.math.BigInteger;

@Value
public class ConstructionSite {
    private String correlation;
    private BuildingType buildingType;
    private String planetId;
    private BigInteger targetLevel;
    private ConstructionSiteType type;
}
