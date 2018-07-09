package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingDeconstructionResourcesLeaseRequested;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingDestructionRequested;
import pl.grizwold.ogame.modules.resources.domain.Cost;

public class BuildingDestructionRequestedListener {

    @EventListener(BuildingDestructionRequested.class)
    public BuildingDeconstructionResourcesLeaseRequested execute(BuildingDestructionRequested event) {
        BuildingType buildingType = event.getBuildingType();
        String planetId = event.getPlanetId();
        Building building = getBuilding(buildingType, planetId);

        Cost cost = calculateResourcesNeededToDeconstruct(building);
        checkBuildingLevel(building);
        checkResourcesAvailable(cost, planetId);
        ConstructionSite constructionSite = saveConstructionSite(building);

        return createBuildingDeconstructionResourcesLeaseRequestedEvent(planetId, cost, constructionSite);
    }

    private Building getBuilding(BuildingType buildingType, String planetId) {
        // gets building information from modules DB
        return null;
    }

    private Cost calculateResourcesNeededToDeconstruct(Building building) {
        // calculates building deconstruction cost using Ogame formulas
        return null;
    }

    private void checkBuildingLevel(Building building) {
        // validate if building level is above 0
    }

    private void checkResourcesAvailable(Cost cost, String planetId) {
        // validate if there are enough resources on planet
    }

    private ConstructionSite saveConstructionSite(Building building) {
        // save construction site with target building data (how the building will be after (de)construction)
        Building targetBuildingState = new Building(building.getLevel() - 1, building.getType(), building.getOwner(), building.getPlanetId());
        return new ConstructionSite("DB provided ID", targetBuildingState);
    }

    private BuildingDeconstructionResourcesLeaseRequested createBuildingDeconstructionResourcesLeaseRequestedEvent(String planetId, Cost cost, ConstructionSite constructionSite) {
        return new BuildingDeconstructionResourcesLeaseRequested(cost, constructionSite.getId(), planetId);
    }
}
