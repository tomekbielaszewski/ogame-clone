package pl.grizwold.ogame.modules.resources.events.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;

@Value
public class BuildingDeconstructionResourcesLeased extends Event {
    private String resourceLeaseId;
    private String constructionSiteId;
    private String planetId;
}
