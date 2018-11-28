package pl.grizwold.ogame.modules.resources.client;

import org.springframework.stereotype.Service;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.resources.domain.Cost;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseRequested;

@Service
public class ResourcesEventFactory {

    public static ResourcesLeaseRequested createResourcesLeaseRequestedEvent(Event source, Cost cost, String planetId) {
        return new ResourcesLeaseRequested(source, cost, planetId);
    }
}
