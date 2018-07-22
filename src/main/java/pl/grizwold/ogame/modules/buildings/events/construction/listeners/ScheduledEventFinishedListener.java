package pl.grizwold.ogame.modules.buildings.events.construction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeased;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventFinished;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventRequested;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType.CONSTRUCTION;

public class ScheduledEventFinishedListener {

    @EventListener(ScheduledEventFinished.class)
    public BuildingConstructionFinished execute(ScheduledEventFinished event) {
        ConstructionSite constructionSite = getConstructionSite(event.getCorrelationToken());
        BuildingConstructionFinished nextEvent = null;

        if (constructionSite != null && constructionSite.getType() == CONSTRUCTION) {
            nextEvent = createConstructionFinishedEvent(event);
        }

        return nextEvent;
    }

    private ConstructionSite getConstructionSite(String constructionSiteId) {
        // get construction site from module DB
        Building targetBuildingState = new Building(1, BuildingType.METAL_MINE, "owner", "planetId");
        return new ConstructionSite(constructionSiteId, targetBuildingState, CONSTRUCTION);
    }

    private BuildingConstructionFinished createConstructionFinishedEvent(Event source) {
        return new BuildingConstructionFinished(source);
    }
}
