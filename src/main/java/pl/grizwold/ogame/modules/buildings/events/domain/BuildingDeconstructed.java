package pl.grizwold.ogame.modules.buildings.events.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;

@Value
public class BuildingDeconstructed extends Event {
    private Building building; // you should not send domain data. Minimize amount of data in event
}
