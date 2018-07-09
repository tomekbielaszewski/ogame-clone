package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingDeconstructed;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingDeconstructionFinished;
import pl.grizwold.ogame.modules.resources.events.domain.ResourceLeaseUsed;

import java.util.Arrays;
import java.util.List;

public class BuildingDeconstructionFinishedListener {

    @EventListener(BuildingDeconstructionFinished.class)
    public List<Event> execute(BuildingDeconstructionFinished event) {
        ConstructionSite constructionSite = getConstructionSite(event.getConstructionSiteId());

        checkResourcesLease(event.getResourcesLeaseId());
        checkConstructionSite(event.getConstructionSiteId());
        saveBuilding(constructionSite.getTargetBuildingState());

        Event resourcesLeaseUsedRequest = createResourcesLeaseUsedEvent(event.getResourcesLeaseId());
        Event buildingDeconstructed = createBuildingDeconstructedEvent(constructionSite.getTargetBuildingState());

        return Arrays.asList(resourcesLeaseUsedRequest, buildingDeconstructed);
    }

    private ConstructionSite getConstructionSite(String constructionSiteId) {
        // get construction site from modules DB
        return null;
    }

    private void checkResourcesLease(String resourcesLeaseId) {
        // validate existence of resources lease in resources module
    }

    private void checkConstructionSite(String constructionSiteId) {
        // validate existence of construction site
    }

    private void saveBuilding(Building targetBuildingState) {

    }

    private Event createResourcesLeaseUsedEvent(String resourcesLeaseId) {
        return new ResourceLeaseUsed(resourcesLeaseId);
    }

    private Event createBuildingDeconstructedEvent(Building targetBuildingState) {
        return new BuildingDeconstructed(targetBuildingState);
    }
}
