package pl.grizwold.ogame.modules.buildings.events.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;

@Value
public class BuildingLeveledUp extends Event {
    private Building building;
    private String planetId;
}
