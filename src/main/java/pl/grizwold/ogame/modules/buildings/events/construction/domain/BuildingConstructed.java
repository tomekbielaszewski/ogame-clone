package pl.grizwold.ogame.modules.buildings.events.construction.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BuildingConstructed extends Event {
    private final Building building;

    public BuildingConstructed(Event event, Building building) {
        super(event);
        this.building = building;
    }
}
