package pl.grizwold.ogame.modules.buildings.events.construction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeased;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventRequested;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType.CONSTRUCTION;

public class ResourcesLeasedListener {

    @EventListener(ResourcesLeased.class)
    public ScheduledEventRequested execute(ResourcesLeased event) {
        ConstructionSite constructionSite = getConstructionSite(event.getCorrelationToken());
        ScheduledEventRequested scheduledEvent = null;

        if (constructionSite != null && constructionSite.getType() == CONSTRUCTION) {
            long constructionDuration = calculateConstructionDurationInSeconds(constructionSite.getType(), constructionSite.getBuildingType(), constructionSite.getPlanetId(), constructionSite.getTargetLevel());
            LocalDateTime dateTimeOfConstructionFinish = convertDurationToExactDateTime(constructionDuration);

            scheduledEvent = createScheduledEvent(event, dateTimeOfConstructionFinish);
        }

        return scheduledEvent;
    }

    private ConstructionSite getConstructionSite(String constructionSiteId) {
        // get construction site from module DB
        Building targetBuildingState = new Building(BigInteger.ONE, BuildingType.METAL_MINE, "owner", "planetId");
        return new ConstructionSite(constructionSiteId, BuildingType.METAL_MINE, "1", BigInteger.ONE, CONSTRUCTION);
    }

    private long calculateConstructionDurationInSeconds(ConstructionSiteType type, BuildingType buildingType, String planetId, BigInteger targetLevel) {
        // use Ogame formula to calculate time needed to construct a building
        return 1;
    }

    private LocalDateTime convertDurationToExactDateTime(long constructionDuration) {
        return LocalDateTime.now().plus(constructionDuration, ChronoUnit.SECONDS);
    }

    private ScheduledEventRequested createScheduledEvent(Event source, LocalDateTime finishDate) {
        return new ScheduledEventRequested(source, finishDate);
    }
}
