package pl.grizwold.ogame.modules.buildings.events.construction.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.buildings.dao.BuildingDao;
import pl.grizwold.ogame.modules.buildings.dao.ConstructionSiteDao;
import pl.grizwold.ogame.modules.buildings.dao.InitialBuildingCostDao;
import pl.grizwold.ogame.modules.buildings.domain.*;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructionRequested;
import pl.grizwold.ogame.modules.resources.client.ResourcesEventFactory;
import pl.grizwold.ogame.modules.resources.client.ResourcesReadService;
import pl.grizwold.ogame.modules.resources.domain.Cost;
import pl.grizwold.ogame.modules.resources.events.domain.ResourcesLeaseRequested;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BuildingConstructionRequestedListener {
    private BuildingDao buildingDao;
    private ConstructionSiteDao constructionSiteDao;
    private InitialBuildingCostDao initialBuildingCostDao;
    private ResourcesReadService resourcesService;

    @Autowired
    public BuildingConstructionRequestedListener(BuildingDao buildingDao, ConstructionSiteDao constructionSiteDao, InitialBuildingCostDao initialBuildingCostDao, ResourcesReadService resourcesService) {
        this.buildingDao = buildingDao;
        this.constructionSiteDao = constructionSiteDao;
        this.initialBuildingCostDao = initialBuildingCostDao;
        this.resourcesService = resourcesService;
    }

    @EventListener(BuildingConstructionRequested.class)
    public ResourcesLeaseRequested execute(BuildingConstructionRequested event) {
        String planetId = event.getPlanetId();
        Building building = getBuilding(event.getBuildingType(), planetId);

        Cost cost = calculateResourcesNeededToLevelUp(building);
        checkResourcesAvailable(cost, planetId);
        createConstructionSite(event.getCorrelationToken(), building);

        return createResourcesLease(event, cost, planetId);
    }

    private Building getBuilding(BuildingType buildingType, String planetId) {
        return buildingDao.findByTypeAndPlanetId(buildingType, planetId)
                .orElse(new Building(BigInteger.ZERO, buildingType, "ownerId", planetId));
    }

    private Cost calculateResourcesNeededToLevelUp(Building building) {
        InitialBuildingCost initialCost = initialBuildingCostDao.getByBuildingType(building.getType());
        BigInteger targetLevel = building.getLevel().add(BigInteger.ONE);
        return new Cost(
                calculateResource(targetLevel, initialCost.getInitialCost().getMetal(), initialCost.getMultiplier()),
                calculateResource(targetLevel, initialCost.getInitialCost().getCrystal(), initialCost.getMultiplier()),
                calculateResource(targetLevel, initialCost.getInitialCost().getDeuterium(), initialCost.getMultiplier())
        );
    }

    private int calculateResource(BigInteger level, int resource, BigDecimal multiplier) {
        return multiplier.pow(level.subtract(BigInteger.ONE).intValue())
                .multiply(BigDecimal.valueOf(resource))
                .intValue();
    }

    private void checkResourcesAvailable(Cost cost, String planetId) {
        if (!resourcesService.hasEnoughResources(cost, planetId)) {
            // throws InsufficientResourcesException?
            // rises InsufficientResources event?
        }
    }

    private void createConstructionSite(String correlationToken, Building building) {
        BigInteger targetLevel = building.getLevel().add(BigInteger.ONE);
        ConstructionSite constructionSite = new ConstructionSite(correlationToken, building.getType(), building.getPlanetId(), targetLevel, ConstructionSiteType.CONSTRUCTION);
        constructionSiteDao.save(constructionSite);
    }

    private ResourcesLeaseRequested createResourcesLease(Event source, Cost cost, String planetId) {
        return ResourcesEventFactory.createResourcesLeaseRequestedEvent(source, cost, planetId);
    }
}
