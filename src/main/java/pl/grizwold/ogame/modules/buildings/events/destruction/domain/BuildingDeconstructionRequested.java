package pl.grizwold.ogame.modules.buildings.events.destruction.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BuildingDeconstructionRequested extends Event {
    private String planetId;
    private BuildingType buildingType;

    public BuildingDeconstructionRequested(Event event, String planetId, BuildingType buildingType) {
        super(event);
        this.planetId = planetId;
        this.buildingType = buildingType;
    }
}
