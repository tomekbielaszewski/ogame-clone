package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.resources.events.domain.BuildingConstructionResourcesLeased;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledBuildingConstructionFinishRequest;

public class BuildingConstructionResourcesLeasedListener {

    @EventListener(BuildingConstructionResourcesLeased.class)
    public ScheduledBuildingConstructionFinishRequest execute(BuildingConstructionResourcesLeased event) {
        return scheduleBuildingConstructionFinish();
    }

    private ScheduledBuildingConstructionFinishRequest scheduleBuildingConstructionFinish() {
        return null;
    }
}
