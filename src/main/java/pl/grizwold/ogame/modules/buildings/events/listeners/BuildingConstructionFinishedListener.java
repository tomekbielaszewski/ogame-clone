package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingLeveledUp;

public class BuildingConstructionFinishedListener {

    @EventListener(BuildingConstructionFinishedListener.class)
    public BuildingLeveledUp execute(BuildingConstructionFinished event) {
        checkResourcesLease(event.getResourcesLeaseId());
        destroyResourceLease(event.getResourcesLeaseId());
        Building leveledUpBuilding = incrementBuildingLevel(event.getBuildingType(), event.getPlanetId());
        return createBuildingLeveledUpEvent(leveledUpBuilding);
    }

    private void checkResourcesLease(String resourcesLeaseId) {

    }

    private void destroyResourceLease(String resourcesLeaseId) {

    }

    private Building incrementBuildingLevel(BuildingType buildingType, String planetId) {
        return null;
    }

    private BuildingLeveledUp createBuildingLeveledUpEvent(Building leveledUpBuilding) {
        return null;
    }
}
