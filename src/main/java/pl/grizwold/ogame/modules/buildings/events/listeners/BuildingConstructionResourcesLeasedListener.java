package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingConstructionResourcesLeased;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventRequested;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BuildingConstructionResourcesLeasedListener {

    @EventListener(BuildingConstructionResourcesLeased.class)
    public ScheduledEventRequested execute(BuildingConstructionResourcesLeased event) {
        ConstructionSite constructionSite = getConstructionSite(event.getConstructionSiteId());
        attachResourceLeaseToConstructionSite(event.getResourceLeaseId(), constructionSite);
        long constructionDuration = calculateConstructionDurationInSeconds(constructionSite.getBuilding());
        LocalDateTime dateTimeOfConstructionFinish = LocalDateTime.now().plus(constructionDuration, ChronoUnit.SECONDS);
        return scheduleEvent(dateTimeOfConstructionFinish, createConstructionFinishedEvent(event, constructionSite.getBuilding()));
    }

    private void attachResourceLeaseToConstructionSite(String resourceLeaseId, ConstructionSite constructionSite) {
        // update construction site with resourceLeaseId
    }

    private ConstructionSite getConstructionSite(String constructionSiteId) {
        // get construction site from module DB
        return new ConstructionSite(constructionSiteId, new Building(1, BuildingType.METAL_MINE, "owner", "planetId"));
    }

    private long calculateConstructionDurationInSeconds(Building building) {
        // use Ogame formula to calculate time needed to construct a building
        return 1;
    }

    private BuildingConstructionFinished createConstructionFinishedEvent(BuildingConstructionResourcesLeased event, Building building) {
        return new BuildingConstructionFinished(event.getResourceLeaseId(), building.getType(), building.getPlanetId(), event.getConstructionSiteId());
    }

    private ScheduledEventRequested scheduleEvent(LocalDateTime finish, Event event) {
        return new ScheduledEventRequested(finish, event);
    }
}
