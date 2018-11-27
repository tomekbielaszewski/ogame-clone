package pl.grizwold.ogame.modules.buildings.events.construction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructionRequested;
import pl.grizwold.ogame.modules.resources.domain.Cost;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseRequested;

public class BuildingConstructionRequestedListener {

    @EventListener(BuildingConstructionRequested.class)
    public ResourcesLeaseRequested execute(BuildingConstructionRequested event) {
        String planetId = event.getPlanetId();
        Building building = getBuilding(event.getBuildingType(), planetId);

        Cost cost = calculateResourcesNeededToLevelUp(building);
        checkResourcesAvailable(cost, planetId);
        createConstructionSite(event.getCorrelationToken(), building);

        return createResourcesLeaseRequestEvent(event, cost, planetId);
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

    private void createConstructionSite(String correlationToken, Building building) {
        // save construction site with building data
        Building targetBuildingState = new Building(building.getLevel() + 1, building.getType(), building.getOwner(), building.getPlanetId());
        new ConstructionSite(correlationToken, targetBuildingState, ConstructionSiteType.CONSTRUCTION);
    }

    private ResourcesLeaseRequested createResourcesLeaseRequestEvent(Event source, Cost cost, String planetId) {
        return new ResourcesLeaseRequested(source, cost, planetId);
    }
}
