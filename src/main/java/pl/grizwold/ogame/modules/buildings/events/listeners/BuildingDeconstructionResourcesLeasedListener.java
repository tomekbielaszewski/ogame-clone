package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingDeconstructionResourcesLeased;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventRequested;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BuildingDeconstructionResourcesLeasedListener {

    @EventListener(BuildingDeconstructionResourcesLeased.class)
    public ScheduledEventRequested execute(BuildingDeconstructionResourcesLeased event) {
        ConstructionSite constructionSite = getConstructionSite(event.getConstructionSiteId());

        attachResourceLeaseToConstructionSite(event.getResourceLeaseId(), constructionSite);
        long deconstructionDuration = calculateDeconstructionDurationInSeconds(constructionSite.getTargetBuildingState());
        LocalDateTime dateTimeOfDeconstructionFinish = convertDurationToExactDateTime(deconstructionDuration);

        return scheduledEvent(dateTimeOfDeconstructionFinish, createConstructionFinishedEvent(event.getResourceLeaseId(), event.getConstructionSiteId()));
    }

    private ConstructionSite getConstructionSite(String constructionSiteId) {
        // get construction site from module DB
        return new ConstructionSite(constructionSiteId, new Building(1, BuildingType.METAL_MINE, "owner", "planetId"));
    }

    private void attachResourceLeaseToConstructionSite(String resourceLeaseId, ConstructionSite constructionSite) {
        // update construction site with resourceLeaseId
    }

    private long calculateDeconstructionDurationInSeconds(Building building) {
        // use Ogame formula to calculate time needed to deconstruct a building
        return 1;
    }

    private LocalDateTime convertDurationToExactDateTime(long constructionDuration) {
        return LocalDateTime.now().plus(constructionDuration, ChronoUnit.SECONDS);
    }

    private BuildingConstructionFinished createConstructionFinishedEvent(String resourceLeaseId, String constructionSiteId) {
        return new BuildingConstructionFinished(resourceLeaseId, constructionSiteId);
    }

    private ScheduledEventRequested scheduledEvent(LocalDateTime finish, Event event) {
        return new ScheduledEventRequested(finish, event);
    }
}
