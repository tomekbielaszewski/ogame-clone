package pl.grizwold.ogame.modules.scheduler.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingConstructionFinished;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledBuildingConstructionFinishRequest;

public class ScheduledBuildingConstructionFinishRequestListener {

    @EventListener(ScheduledBuildingConstructionFinishRequest.class)
    public BuildingConstructionFinished execute(ScheduledBuildingConstructionFinishRequest event) {
        //deffer the event somehow

        //totally incorrect data, just keeping the flow here. Will think about it later
        return new BuildingConstructionFinished("1", null, "");
    }
}
