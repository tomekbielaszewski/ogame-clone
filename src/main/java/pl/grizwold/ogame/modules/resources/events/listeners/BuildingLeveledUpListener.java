package pl.grizwold.ogame.modules.resources.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingConstructed;
import pl.grizwold.ogame.modules.resources.domain.ResourceExtractionRate;

public class BuildingLeveledUpListener {

    @EventListener(BuildingConstructed.class)
    public void execute(BuildingConstructed event) {
        if(isResourceExtractionUpgraded(event.getBuilding())) {
            ResourceExtractionRate extractionRate = recalculateResourceExtractionRate(event.getBuilding());
            saveResourceExtractionRate(extractionRate);
        }
    }

    private boolean isResourceExtractionUpgraded(Building building) {
        return false;
    }

    private ResourceExtractionRate recalculateResourceExtractionRate(Building building) {
        return null;
    }

    private void saveResourceExtractionRate(ResourceExtractionRate extractionRate) {

    }
}
