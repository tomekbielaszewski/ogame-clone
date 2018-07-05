package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingLeveledUp;
import pl.grizwold.ogame.modules.resources.events.domain.ResourceLeaseUsed;

import java.util.Arrays;
import java.util.List;

public class BuildingConstructionFinishedListener {

    @EventListener(BuildingConstructionFinishedListener.class)
    public List<Event> execute(BuildingConstructionFinished event) {
        checkResourcesLease(event.getResourcesLeaseId());
        checkConstructionSite(event.getConstructionSiteId());
        Event destroyLease = destroyResourceLease(event.getResourcesLeaseId());
        Event buildingLeveledUp = incrementBuildingLevel(event.getBuildingType(), event.getPlanetId());
        return Arrays.asList(destroyLease, buildingLeveledUp);
    }

    private void checkResourcesLease(String resourcesLeaseId) {
        //validate existence of resource lease (construction could be canceled?)
    }

    private void checkConstructionSite(String constructionSiteId) {
        //validate existence of construction site (could be removed/canceled?)
    }

    private Event destroyResourceLease(String resourcesLeaseId) {
        return createDestroyResourceLeaseEvent(resourcesLeaseId);
    }

    private Event incrementBuildingLevel(BuildingType buildingType, String planetId) {
        //get building from module db
        //increment building level
        //save building
        return createBuildingLeveledUpEvent(null);
    }

    private BuildingLeveledUp createBuildingLeveledUpEvent(Building leveledUpBuilding) {
        return null;
    }

    private ResourceLeaseUsed createDestroyResourceLeaseEvent(String resourcesLeaseId) {
        return new ResourceLeaseUsed(resourcesLeaseId);
    }
}
