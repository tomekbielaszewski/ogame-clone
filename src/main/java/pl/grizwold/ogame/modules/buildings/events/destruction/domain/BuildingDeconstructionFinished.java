package pl.grizwold.ogame.modules.buildings.events.destruction.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;

@Value
public class BuildingDeconstructionFinished extends Event {
    private String resourcesLeaseId;
    private String constructionSiteId;
}
