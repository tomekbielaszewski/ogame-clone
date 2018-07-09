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
        String planetId = event.getPlanetId();
        Building building = getBuilding(event.getBuildingType(), planetId);

        Cost cost = calculateResourcesNeededToLevelUp(building);
        checkResourcesAvailable(cost, planetId);
        ConstructionSite constructionSite = saveConstructionSite(building);

        return createBuildingConstructionResourcesLeaseRequestEvent(cost, constructionSite.getId(), planetId);
    }

    private Building getBuilding(BuildingType buildingType, String planetId) {
        // get building from modules database
        // or create new with 0 lvl
        return new Building(1, buildingType, "ownerId", planetId);
    }

    private Cost calculateResourcesNeededToLevelUp(Building building) {
        // get actual building level
        // using Ogame formula calculate the cost for level up
        return new Cost(48, 24, 0);
    }

    private void checkResourcesAvailable(Cost cost, String planetId) {
        // use resource module to check if resource cost is spendable
        // throws InsufficientResourcesException?
        // rises InsufficientResources event?
    }

    private ConstructionSite saveConstructionSite(Building building) {
        // save construction site with building data
        Building targetBuildingState = new Building(building.getLevel() + 1, building.getType(), building.getOwner(), building.getPlanetId());
        return new ConstructionSite("DB provided ID", targetBuildingState);
    }

    private BuildingConstructionResourcesLeaseRequested createBuildingConstructionResourcesLeaseRequestEvent(Cost cost, String constructionSiteId, String planetId) {
        return new BuildingConstructionResourcesLeaseRequested(constructionSiteId, cost, planetId);
    }
}
