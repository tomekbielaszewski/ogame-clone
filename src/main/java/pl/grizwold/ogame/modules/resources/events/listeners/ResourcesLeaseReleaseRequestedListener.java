package pl.grizwold.ogame.modules.resources.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.resources.domain.ResourcesLease;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseReleased;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseRequested;

import static pl.grizwold.ogame.modules.resources.domain.Status.ACTIVE;

public class ResourcesLeaseReleaseRequestedListener {

    @EventListener(ResourcesLeaseRequested.class)
    public ResourcesLeaseReleased execute(ResourcesLeaseRequested event) {
        ResourcesLease resourcesLease = getResourceLease(event.getCorrelationToken());
        ResourcesLeaseReleased nextEvent = null;

        if (resourcesLease != null && resourcesLease.getStatus() == ACTIVE) {
            cancelResourceLease(resourcesLease);
            addResources(resourcesLease);
            nextEvent = new ResourcesLeaseReleased(event);
        }

        return nextEvent;
    }

    private ResourcesLease getResourceLease(String correlationToken) {
        // get resource lease from modules DB
        return null;
    }

    private void cancelResourceLease(ResourcesLease resourcesLease) {
        // set resource lease status to CANCELLED
    }

    private void addResources(ResourcesLease resourcesLease) {
        String planetId = resourcesLease.getPlanetId();
        // add resources to planet
    }
}
