package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingConstructionRequested;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingConstructionResourcesLeaseRequested;

public class BuildingConstructionRequestedListener {

    @EventListener(BuildingConstructionRequested.class)
    public BuildingConstructionResourcesLeaseRequested execute(BuildingConstructionRequested event) {
        checkResourcesAvailable(event.getBuildingType(), event.getPlanetId());
        return createBuildingConstructionResourcesLeaseRequestEvent(event.getBuildingType());
    }

    private void checkResourcesAvailable(BuildingType buildingType, String planetId) {

    }

    private BuildingConstructionResourcesLeaseRequested createBuildingConstructionResourcesLeaseRequestEvent(BuildingType buildingType) {
        return null;
    }
}
