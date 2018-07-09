package pl.grizwold.ogame.modules.resources.events.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.resources.domain.Cost;

@Value
public class BuildingDeconstructionResourcesLeaseRequested extends Event {
    private Cost cost;
    private String constructionSiteId;
    private String planetId;
}
