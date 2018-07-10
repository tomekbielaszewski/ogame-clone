package pl.grizwold.ogame.modules.buildings.events.construction.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;

@Value
public class BuildingConstructionRequested extends Event {
    private BuildingType buildingType;
    private String planetId;
}
