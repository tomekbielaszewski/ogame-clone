package pl.grizwold.ogame.modules.buildings.events.destruction.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSiteType;
import pl.grizwold.ogame.modules.buildings.events.destruction.domain.BuildingDeconstructionRequested;
import pl.grizwold.ogame.modules.resources.domain.Cost;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseRequested;

import java.math.BigInteger;

public class BuildingDeconstructionRequestedListener {

    @EventListener(BuildingDeconstructionRequested.class)
    public ResourcesLeaseRequested execute(BuildingDeconstructionRequested event) {
        String planetId = event.getPlanetId();
        Building building = getBuilding(event.getBuildingType(), planetId);

        Cost cost = calculateResourcesNeededToDeconstruct(building);
        checkBuildingLevel(building);
        checkResourcesAvailable(cost, planetId);
        saveConstructionSite(event.getCorrelationToken(), building);

        return createResourcesLeaseRequestedEvent(event, planetId, cost);
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

    private void saveConstructionSite(String correlationToken, Building building) {
        // save construction site with target building data (how the building will be after (de)construction)
        BigInteger targetLevel = building.getLevel().add(BigInteger.ONE);
        ConstructionSite constructionSite = new ConstructionSite(correlationToken, building.getType(), building.getPlanetId(), targetLevel, ConstructionSiteType.CONSTRUCTION);
    }

    private ResourcesLeaseRequested createResourcesLeaseRequestedEvent(Event source, String planetId, Cost cost) {
        return new ResourcesLeaseRequested(source, cost, planetId);
    }
}
