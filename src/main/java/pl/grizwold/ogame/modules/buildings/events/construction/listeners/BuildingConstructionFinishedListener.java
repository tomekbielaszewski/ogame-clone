package pl.grizwold.ogame.modules.buildings.events.construction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructed;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseUsed;

import java.util.Arrays;
import java.util.List;

public class BuildingConstructionFinishedListener {

    @EventListener(BuildingConstructionFinished.class)
    public List<Event> execute(BuildingConstructionFinished event) {
        ConstructionSite constructionSite = getConstructionSite(event.getCorrelationToken());

        checkResourcesLease(event.getCorrelationToken());
        checkConstructionSite(event.getCorrelationToken());
        Building newBuilding = saveBuilding(constructionSite);

        Event resourcesLeaseUsed = createResourcesLeaseUsedEvent(event);
        Event buildingConstructed = createBuildingConstructedEvent(event, newBuilding);

        return Arrays.asList(resourcesLeaseUsed, buildingConstructed);
    }

    private ConstructionSite getConstructionSite(String constructionSiteId) {
        // get construction site from modules DB
        return null;
    }

    private void checkResourcesLease(String resourcesLeaseId) {
        // validate existence of resource lease (construction could be canceled?)
    }

    private void checkConstructionSite(String constructionSiteId) {
        // validate existence of construction site (could be removed/canceled?)
        // validate type of construction site
    }

    private Building saveBuilding(ConstructionSite building) {
        // save changed building in modules DB
        return null;
    }

    private Event createResourcesLeaseUsedEvent(Event source) {
        return new ResourcesLeaseUsed(source);
    }

    private BuildingConstructed createBuildingConstructedEvent(Event source, Building constructedBuilding) {
        return new BuildingConstructed(source, constructedBuilding);
    }
}
