package pl.grizwold.ogame.modules.buildings.events.construction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeased;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventRequested;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ResourcesLeasedListener {

    @EventListener(ResourcesLeased.class)
    public ScheduledEventRequested execute(ResourcesLeased event) {
        ConstructionSite constructionSite = getConstructionSite(event.getCorrelationToken());
        ScheduledEventRequested scheduledEvent = null;

        if(constructionSite != null && constructionSite.getType() == ConstructionSiteType.CONSTRUCTION) {
            long constructionDuration = calculateConstructionDurationInSeconds(constructionSite.getTargetBuildingState());
            LocalDateTime dateTimeOfConstructionFinish = convertDurationToExactDateTime(constructionDuration);

            scheduledEvent = createScheduledEvent(event, dateTimeOfConstructionFinish, createConstructionFinishedEvent(event));
        }

        return scheduledEvent;
    }

    private ConstructionSite getConstructionSite(String constructionSiteId) {
        // get construction site from module DB
        Building targetBuildingState = new Building(1, BuildingType.METAL_MINE, "owner", "planetId");
        return new ConstructionSite(constructionSiteId, targetBuildingState, ConstructionSiteType.CONSTRUCTION);
    }

    private long calculateConstructionDurationInSeconds(Building building) {
        // use Ogame formula to calculate time needed to construct a building
        return 1;
    }

    private LocalDateTime convertDurationToExactDateTime(long constructionDuration) {
        return LocalDateTime.now().plus(constructionDuration, ChronoUnit.SECONDS);
    }

    private BuildingConstructionFinished createConstructionFinishedEvent(Event source) {
        return new BuildingConstructionFinished(source);
    }

    private ScheduledEventRequested createScheduledEvent(Event source, LocalDateTime finish, Event event) {
        return new ScheduledEventRequested(source, finish, event);
    }
}
