package pl.grizwold.ogame.modules.buildings.events.construction.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;

@Value
public class BuildingConstructionFinished extends Event {
    private String resourcesLeaseId;
    private String constructionSiteId;
}
