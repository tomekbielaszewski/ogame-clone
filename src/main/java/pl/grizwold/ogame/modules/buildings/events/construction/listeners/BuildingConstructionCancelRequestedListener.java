package pl.grizwold.ogame.modules.buildings.events.construction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructed;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructionCancelRequested;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseReleaseRequested;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseUsed;

import java.util.Arrays;
import java.util.List;

import static pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType.CONSTRUCTION;

public class BuildingConstructionCancelRequestedListener {

    @EventListener(BuildingConstructionCancelRequested.class)
    public ResourcesLeaseReleaseRequested execute(BuildingConstructionCancelRequested event) {
        ConstructionSite constructionSite = getConstructionSite(event.getCorrelationToken());
        ResourcesLeaseReleaseRequested nextEvent = null;

        if (constructionSite != null && constructionSite.getType() == CONSTRUCTION) {
            cancelConstructionSite(constructionSite);
            nextEvent = new ResourcesLeaseReleaseRequested(event);
        }

        return nextEvent;
    }

    private ConstructionSite getConstructionSite(String correlationToken) {
        // get construction site from modules DB
        return null;
    }

    private void cancelConstructionSite(ConstructionSite constructionSite) {
        // mark construction site as canceled
    }
}
