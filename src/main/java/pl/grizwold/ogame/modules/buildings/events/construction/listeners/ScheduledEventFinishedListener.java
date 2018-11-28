package pl.grizwold.ogame.modules.buildings.events.construction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventFinished;

import java.math.BigInteger;

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
        return new ConstructionSite(constructionSiteId, BuildingType.METAL_MINE, "", BigInteger.ONE, CONSTRUCTION);
    }

    private BuildingConstructionFinished createConstructionFinishedEvent(Event source) {
        return new BuildingConstructionFinished(source);
    }
}
