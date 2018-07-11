package pl.grizwold.ogame.modules.buildings.events.destruction.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BuildingDeconstructed extends Event {
    private Building building; // you should not send domain data. Minimize amount of data in event

    public BuildingDeconstructed(Event event, Building building) {
        super(event);
        this.building = building;
    }
}
