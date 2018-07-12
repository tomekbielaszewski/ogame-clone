package pl.grizwold.ogame.modules.buildings.events.destruction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.destruction.domain.BuildingDeconstructed;
import pl.grizwold.ogame.modules.buildings.events.destruction.domain.BuildingDeconstructionFinished;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseUsed;

import java.util.Arrays;
import java.util.List;

public class BuildingDeconstructionFinishedListener {

    @EventListener(BuildingDeconstructionFinished.class)
    public List<Event> execute(BuildingDeconstructionFinished event) {
        ConstructionSite constructionSite = getConstructionSite(event.getCorrelationToken());

        checkResourcesLease(event.getCorrelationToken());
        checkConstructionSite(event.getCorrelationToken());
        saveBuilding(constructionSite.getTargetBuildingState());

        Event resourcesLeaseUsed = createResourcesLeaseUsedEvent(event);
        Event buildingDeconstructed = createBuildingDeconstructedEvent(event, constructionSite.getTargetBuildingState());

        return Arrays.asList(resourcesLeaseUsed, buildingDeconstructed);
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
        // validate type of construction site to be DECONSTRUCTION
    }

    private void saveBuilding(Building targetBuildingState) {
        // save changed building in modules DB
    }

    private Event createResourcesLeaseUsedEvent(Event source) {
        return new ResourcesLeaseUsed(source);
    }

    private Event createBuildingDeconstructedEvent(Event source, Building targetBuildingState) {
        return new BuildingDeconstructed(source, targetBuildingState);
    }
}
