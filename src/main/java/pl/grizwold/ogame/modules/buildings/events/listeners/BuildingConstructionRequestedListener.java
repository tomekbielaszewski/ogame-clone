package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingConstructionRequested;
import pl.grizwold.ogame.modules.resources.domain.Cost;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingConstructionResourcesLeaseRequested;

public class BuildingConstructionRequestedListener {

    @EventListener(BuildingConstructionRequested.class)
    public BuildingConstructionResourcesLeaseRequested execute(BuildingConstructionRequested event) {
        Building building = getBuilding(event.getBuildingType(), event.getPlanetId());
        Cost cost = calculateResourcesNeededToLevelUp(building);
        checkResourcesAvailable(cost);
        ConstructionSite constructionSite = saveConstructionSite(building);
        return createBuildingConstructionResourcesLeaseRequestEvent(cost, constructionSite.getId(), event.getPlanetId());
    }

    private Building getBuilding(BuildingType buildingType, String planetId) {
        // get building from modules database
        return new Building(1, buildingType, "ownerId", planetId);
    }

    private Cost calculateResourcesNeededToLevelUp(Building building) {
        // get actual building level
        // using Ogame formula calculate the cost for level up
        return new Cost(48, 24, 0);
    }

    private void checkResourcesAvailable(Cost cost) {
        // use resource module to check if resource cost is spendable
        // throws InsufficientResourcesException?
        // rises InsufficientResources event?
    }

    private ConstructionSite saveConstructionSite(Building building) {
        // save construction site with building data
        return new ConstructionSite("DB provided ID", building);
    }

    private BuildingConstructionResourcesLeaseRequested createBuildingConstructionResourcesLeaseRequestEvent(Cost cost, String constructionSiteId, String planetId) {
        return new BuildingConstructionResourcesLeaseRequested(constructionSiteId, cost, planetId);
    }
}
