package pl.grizwold.ogame.modules.buildings.events.destruction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.destruction.domain.BuildingDeconstructionFinished;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeased;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventRequested;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType.DECONSTRUCTION;

public class ResourcesLeasedListener {

    @EventListener(ResourcesLeased.class)
    public ScheduledEventRequested execute(ResourcesLeased event) {
        ConstructionSite constructionSite = getConstructionSite(event.getCorrelationToken());
        ScheduledEventRequested scheduledEvent = null;

        if(constructionSite != null && constructionSite.getType() == DECONSTRUCTION) {
            long deconstructionDuration = calculateDeconstructionDurationInSeconds(constructionSite.getTargetBuildingState());
            LocalDateTime dateTimeOfDeconstructionFinish = convertDurationToExactDateTime(deconstructionDuration);

            scheduledEvent = createScheduledEvent(event, dateTimeOfDeconstructionFinish);
        }

        return scheduledEvent;
    }

    private ConstructionSite getConstructionSite(String constructionSiteId) {
        // get construction site from module DB
        Building targetBuildingState = new Building(1, BuildingType.METAL_MINE, "owner", "planetId");
        return new ConstructionSite(constructionSiteId, targetBuildingState, DECONSTRUCTION);
    }

    private long calculateDeconstructionDurationInSeconds(Building building) {
        // use Ogame formula to calculate time needed to deconstruct a building
        return 1;
    }

    private LocalDateTime convertDurationToExactDateTime(long constructionDuration) {
        return LocalDateTime.now().plus(constructionDuration, ChronoUnit.SECONDS);
    }

    private ScheduledEventRequested createScheduledEvent(Event source, LocalDateTime finish) {
        return new ScheduledEventRequested(source, finish);
    }
}
