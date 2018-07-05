package pl.grizwold.ogame.modules.buildings.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingDestructionFinished;
import pl.grizwold.ogame.modules.buildings.events.domain.BuildingDestructionRequested;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventRequested;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BuildingDestructionRequestedListener {

    @EventListener(BuildingDestructionRequested.class)
    public ScheduledEventRequested execute(BuildingDestructionRequested event) {
        String planetId = event.getPlanetId();
        BuildingType buildingType = event.getBuildingType();

        checkBuildingLevel(buildingType, planetId);
        long destructionDurationInSeconds = calculateDestructionDurationInSeconds(buildingType, planetId);
        LocalDateTime destructionFinishDateTime = convertDurationToExactDateTime(destructionDurationInSeconds);
        return scheduledEvent(destructionFinishDateTime, createBuildingDestructionFinished(buildingType, planetId));
    }

    private void checkBuildingLevel(BuildingType buildingType, String planetId) {
        // validate if building level is above 0
        // if not raise event to the user
    }

    private long calculateDestructionDurationInSeconds(BuildingType buildingType, String planetId) {
        // calculate destruction time using Ogame formulas
        return 0;
    }

    private LocalDateTime convertDurationToExactDateTime(long destructionDurationInSeconds) {
        return LocalDateTime.now().plus(destructionDurationInSeconds, ChronoUnit.SECONDS);
    }

    private BuildingDestructionFinished createBuildingDestructionFinished(BuildingType buildingType, String planetId) {
        return new BuildingDestructionFinished(planetId, buildingType);
    }

    private ScheduledEventRequested scheduledEvent(LocalDateTime destructionFinishDateTime, BuildingDestructionFinished buildingDestructionFinished) {
        return new ScheduledEventRequested(destructionFinishDateTime, buildingDestructionFinished);
    }
}
