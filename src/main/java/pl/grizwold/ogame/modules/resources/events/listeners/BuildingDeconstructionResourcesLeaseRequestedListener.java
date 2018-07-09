package pl.grizwold.ogame.modules.resources.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.resources.domain.Cost;
import pl.grizwold.ogame.modules.resources.domain.ResourcesLease;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingDeconstructionResourcesLeaseRequested;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingDeconstructionResourcesLeased;

public class BuildingDeconstructionResourcesLeaseRequestedListener {

    @EventListener(BuildingDeconstructionResourcesLeaseRequested.class)
    public BuildingDeconstructionResourcesLeased execute(BuildingDeconstructionResourcesLeaseRequested event) {
        Cost cost = event.getCost();
        event.getConstructionSiteId();
        String planetId = event.getPlanetId();

        checkResourcesAvailable(cost, planetId);
        ResourcesLease lease = makeResourcesLease(cost, planetId);

        return createBuildingDeconstructionResourcesLeasedEvent(lease, event.getConstructionSiteId(), planetId);
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

    private BuildingDeconstructionResourcesLeased createBuildingDeconstructionResourcesLeasedEvent(ResourcesLease lease, String constructionSiteId, String planetId) {
        return new BuildingDeconstructionResourcesLeased(lease.getId(), constructionSiteId, planetId);
    }
}
