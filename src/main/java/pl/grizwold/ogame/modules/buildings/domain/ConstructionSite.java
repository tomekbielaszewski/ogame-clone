package pl.grizwold.ogame.modules.buildings.domain;

import lombok.Value;

@Value
public class ConstructionSite {
    private String id;
    private Building targetBuildingState;
}
