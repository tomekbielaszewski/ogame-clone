package pl.grizwold.ogame.modules.resources.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructed;
import pl.grizwold.ogame.modules.resources.domain.ResourceExtractionRate;
import pl.grizwold.ogame.modules.resources.domain.ResourcesCapacity;

public class BuildingConstructedListener {

    @EventListener(BuildingConstructed.class)
    public void execute(BuildingConstructed event) {
        handleResourcesExtractionUpgrade(event);
        handleStorageUpgrade(event);
    }

    private void handleResourcesExtractionUpgrade(BuildingConstructed event) {
        if (isResourceExtractionUpgraded(event.getBuilding())) {
            ResourceExtractionRate extractionRate = recalculateResourcesExtractionRate(event.getBuilding());
            saveResourcesExtractionRate(extractionRate);
        }
    }

    private void handleStorageUpgrade(BuildingConstructed event) {
        if (isResourcesStorageUpgraded(event.getBuilding())) {
            ResourcesCapacity resourcesCapacity = recalculateResourcesCapacity(event.getBuilding());
            saveResourcesCapacity(resourcesCapacity);
        }
    }

    private boolean isResourceExtractionUpgraded(Building building) {
        return false;
    }

    private ResourceExtractionRate recalculateResourcesExtractionRate(Building building) {
        return null;
    }

    private void saveResourcesExtractionRate(ResourceExtractionRate extractionRate) {

    }

    private boolean isResourcesStorageUpgraded(Building building) {
        return false;
    }

    private ResourcesCapacity recalculateResourcesCapacity(Building building) {
        return null;
    }

    private void saveResourcesCapacity(ResourcesCapacity resourcesCapacity) {

    }
}
