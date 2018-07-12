package pl.grizwold.ogame.modules.buildings.events.construction.domain;

import pl.grizwold.ogame.common.domain.Event;

public class BuildingConstructionCancelRequested extends Event {
    public BuildingConstructionCancelRequested(String ownerId, String correlationToken) {
        super(ownerId, correlationToken);
    }
}
