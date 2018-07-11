package pl.grizwold.ogame.modules.buildings.events.construction.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BuildingConstructionRequested extends Event {
    private final BuildingType buildingType;
    private final String planetId;

    public BuildingConstructionRequested(String ownerId, String correlationToken, BuildingType buildingType, String planetId) {
        super(ownerId, correlationToken);
        this.buildingType = buildingType;
        this.planetId = planetId;
    }
}
