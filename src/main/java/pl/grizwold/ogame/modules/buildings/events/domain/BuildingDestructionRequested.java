package pl.grizwold.ogame.modules.buildings.events.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;

@Value
public class BuildingDestructionRequested extends Event {
    private String planetId;
    private BuildingType buildingType;
}