package pl.grizwold.ogame.modules.resources.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.resources.domain.Cost;
import pl.grizwold.ogame.modules.resources.domain.ResourcesLease;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingConstructionResourcesLeaseRequested;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingConstructionResourcesLeased;

public class BuildingConstructionResourcesLeaseRequestedListener {

    @EventListener(BuildingConstructionResourcesLeaseRequested.class)
    public BuildingConstructionResourcesLeased execute(BuildingConstructionResourcesLeaseRequested event) {
        checkResourcesAvailable(event.getCost(), event.getPlanetId());
        ResourcesLease lease = makeResourcesLease(event.getCost(), event.getPlanetId());
        return createBuildingConstructionResourcesLeasedEvent(lease, event.getConstructionSiteId());
    }

    private void checkResourcesAvailable(Cost cost, String planetId) {
        // check if resources are available on planet
        // if not raise event to the user
    }

    private ResourcesLease makeResourcesLease(Cost cost, String planetId) {
        // subtract resources from planet
        // save resource lease in module DB
        return new ResourcesLease("DB provided ID", cost.getMetal(), cost.getCrystal(), cost.getDeuterium(), planetId);
    }

    private BuildingConstructionResourcesLeased createBuildingConstructionResourcesLeasedEvent(ResourcesLease lease, String constructionSiteId) {
        return new BuildingConstructionResourcesLeased(lease.getId(), constructionSiteId);
    }
}
