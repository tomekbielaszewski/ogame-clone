package pl.grizwold.ogame.modules.buildings.events.destruction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.destruction.domain.BuildingDeconstructionFinished;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventFinished;

import static pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType.DECONSTRUCTION;

public class ScheduledEventFinishedListener {

    @EventListener(ScheduledEventFinished.class)
    public BuildingDeconstructionFinished execute(ScheduledEventFinished event) {
        ConstructionSite constructionSite = getConstructionSite(event.getCorrelationToken());
        BuildingDeconstructionFinished nextEvent = null;

        if (constructionSite != null && constructionSite.getType() == DECONSTRUCTION) {
            nextEvent = createDeconstructionFinishedEvent(event);
        }

        return nextEvent;
    }

    private ConstructionSite getConstructionSite(String constructionSiteId) {
        // get construction site from module DB
        Building targetBuildingState = new Building(1, BuildingType.METAL_MINE, "owner", "planetId");
        return new ConstructionSite(constructionSiteId, targetBuildingState, DECONSTRUCTION);
    }

    private BuildingDeconstructionFinished createDeconstructionFinishedEvent(Event source) {
        return new BuildingDeconstructionFinished(source);
    }
}
