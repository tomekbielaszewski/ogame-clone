package pl.grizwold.ogame.modules.buildings.events.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;

@Value
public class BuildingConstructionFinished extends Event {
    private String resourcesLeaseId;
    private BuildingType buildingType;
    private String planetId;
}
