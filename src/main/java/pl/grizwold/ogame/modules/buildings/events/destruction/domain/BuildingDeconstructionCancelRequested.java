package pl.grizwold.ogame.modules.buildings.events.destruction.domain;

import pl.grizwold.ogame.common.domain.Event;

public class BuildingDeconstructionCancelRequested extends Event {
    public BuildingDeconstructionCancelRequested(String ownerId, String correlationToken) {
        super(ownerId, correlationToken);
    }
}
