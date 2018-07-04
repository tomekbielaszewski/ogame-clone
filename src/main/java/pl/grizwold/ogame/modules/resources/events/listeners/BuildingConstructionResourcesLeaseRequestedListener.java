package pl.grizwold.ogame.modules.resources.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.resources.domain.ResourcesLease;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingConstructionResourcesLeaseRequested;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingConstructionResourcesLeased;

public class BuildingConstructionResourcesLeaseRequestedListener {

    @EventListener(BuildingConstructionResourcesLeaseRequested.class)
    public BuildingConstructionResourcesLeased execute(BuildingConstructionResourcesLeaseRequested event) {
        ResourcesLease lease = createResourcesLease();
        return createBuildingConstructionResourcesLeasedEvent(lease);
    }

    private ResourcesLease createResourcesLease() {
        return null;
    }

    private BuildingConstructionResourcesLeased createBuildingConstructionResourcesLeasedEvent(ResourcesLease lease) {
        return null;
    }
}
