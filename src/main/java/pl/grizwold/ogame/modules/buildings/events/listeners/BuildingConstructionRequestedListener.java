package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingConstructionRequested;
import pl.grizwold.ogame.modules.resources.domain.ResourcesLease;

public class BuildingConstructionRequestedListener {

    @EventListener(BuildingConstructionRequested.class)
    public void execute(BuildingConstructionRequested event) {
        checkResourcesAvailable(event.getBuildingType(), event.getPlanetId());
        ResourcesLease lease = createResourcesLease(event.getBuildingType());
        scheduleBuildingConstructionFinish(event.getBuildingType(), event.getPlanetId(), lease);
    }

    private void checkResourcesAvailable(BuildingType buildingType, String planetId) {

    }

    private ResourcesLease createResourcesLease(BuildingType buildingType) {
        return null;
    }

    private void scheduleBuildingConstructionFinish(BuildingType buildingType, String planetId, ResourcesLease lease) {

    }
}
