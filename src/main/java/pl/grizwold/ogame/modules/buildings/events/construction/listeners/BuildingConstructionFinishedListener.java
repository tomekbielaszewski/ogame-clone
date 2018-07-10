package pl.grizwold.ogame.modules.buildings.events.construction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingLeveledUp;
import pl.grizwold.ogame.modules.resources.events.domain.ResourceLeaseUsed;

import java.util.Arrays;
import java.util.List;

public class BuildingConstructionFinishedListener {

    @EventListener(BuildingConstructionFinished.class)
    public List<Event> execute(BuildingConstructionFinished event) {
        ConstructionSite constructionSite = getConstructionSite(event.getConstructionSiteId());

        checkResourcesLease(event.getResourcesLeaseId());
        checkConstructionSite(event.getConstructionSiteId());
        saveBuilding(constructionSite.getTargetBuildingState());

        Event destroyLease = createResourcesLeaseUsedEvent(event.getResourcesLeaseId());
        Event buildingLeveledUp = createBuildingLeveledUpEvent(constructionSite.getTargetBuildingState());

        return Arrays.asList(destroyLease, buildingLeveledUp);
    }

    private ConstructionSite getConstructionSite(String constructionSiteId) {
        return null;
    }

    private void checkResourcesLease(String resourcesLeaseId) {
        // validate existence of resource lease (construction could be canceled?)
    }

    private void checkConstructionSite(String constructionSiteId) {
        // validate existence of construction site (could be removed/canceled?)
    }

    private Event createResourcesLeaseUsedEvent(String resourcesLeaseId) {
        return createDestroyResourceLeaseEvent(resourcesLeaseId);
    }

    private void saveBuilding(Building building) {
        // save changed building in modules DB
    }

    private ResourceLeaseUsed createDestroyResourceLeaseEvent(String resourcesLeaseId) {
        return new ResourceLeaseUsed(resourcesLeaseId);
    }

    private BuildingLeveledUp createBuildingLeveledUpEvent(Building leveledUpBuilding) {
        return null;
    }
}
