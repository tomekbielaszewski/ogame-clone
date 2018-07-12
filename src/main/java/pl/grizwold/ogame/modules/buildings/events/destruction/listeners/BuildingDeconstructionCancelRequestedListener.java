package pl.grizwold.ogame.modules.buildings.events.destruction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructionCancelRequested;
import pl.grizwold.ogame.modules.buildings.events.destruction.domain.BuildingDeconstructionCancelRequested;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseReleaseRequested;

import java.util.List;

import static pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType.CONSTRUCTION;
import static pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType.DECONSTRUCTION;

public class BuildingDeconstructionCancelRequestedListener {

    @EventListener(BuildingDeconstructionCancelRequested.class)
    public ResourcesLeaseReleaseRequested execute(BuildingDeconstructionCancelRequested event) {
        ConstructionSite constructionSite = getConstructionSite(event.getCorrelationToken());
        ResourcesLeaseReleaseRequested nextEvent = null;

        if (constructionSite != null && constructionSite.getType() == DECONSTRUCTION) {
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
