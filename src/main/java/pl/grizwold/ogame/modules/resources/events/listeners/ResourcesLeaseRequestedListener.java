package pl.grizwold.ogame.modules.resources.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.resources.domain.Cost;
import pl.grizwold.ogame.modules.resources.domain.ResourcesLease;
import pl.grizwold.ogame.modules.resources.domain.Status;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseRequested;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeased;

public class ResourcesLeaseRequestedListener {

    @EventListener(ResourcesLeaseRequested.class)
    public ResourcesLeased execute(ResourcesLeaseRequested event) {
        checkResourcesAvailable(event.getCost(), event.getPlanetId());
        makeResourcesLease(event.getCorrelationToken(), event.getCost(), event.getPlanetId());
        return createBuildingConstructionResourcesLeasedEvent(event);
    }

    private void checkResourcesAvailable(Cost cost, String planetId) {
        // check if resources are available on planet
        // if not raise event to the user
    }

    private ResourcesLease makeResourcesLease(String correlationToken, Cost cost, String planetId) {
        // subtract resources from planet
        // save resource lease in module DB
        return new ResourcesLease(correlationToken, cost.getMetal(), cost.getCrystal(), cost.getDeuterium(), planetId, Status.ACTIVE);
    }

    private ResourcesLeased createBuildingConstructionResourcesLeasedEvent(Event source) {
        return new ResourcesLeased(source);
    }
}
