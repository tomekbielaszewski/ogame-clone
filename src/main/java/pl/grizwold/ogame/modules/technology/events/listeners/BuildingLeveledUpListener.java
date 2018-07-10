package pl.grizwold.ogame.modules.technology.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.events.construction.domain.BuildingLeveledUp;
import pl.grizwold.ogame.modules.technology.domain.Technology;
import pl.grizwold.ogame.modules.technology.domain.TechnologyTree;

import java.util.List;

public class BuildingLeveledUpListener {

    @EventListener(BuildingLeveledUp.class)
    public void execute(BuildingLeveledUp event) {
        TechnologyTree technologyTree = recalculateTechnologyTree(event.getBuilding());
        List<Technology> technologies = availableNewTechnology(technologyTree);

        if(!technologies.isEmpty()) {
            saveTechnologyTree(technologyTree);
            sendNewTechnologyAvailableEvent(technologies);
        }
    }

    private TechnologyTree recalculateTechnologyTree(Building building) {
        return null;
    }

    private List<Technology> availableNewTechnology(TechnologyTree technologyTree) {
        return null;
    }

    private void saveTechnologyTree(TechnologyTree technologyTree) {

    }

    private void sendNewTechnologyAvailableEvent(List<Technology> technologies) {

    }
}
