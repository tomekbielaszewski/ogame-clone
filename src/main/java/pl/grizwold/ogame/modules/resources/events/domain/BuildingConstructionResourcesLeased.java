package pl.grizwold.ogame.modules.resources.events.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.resources.domain.ResourcesLease;

@Value
public class BuildingConstructionResourcesLeased extends Event {
    private ResourcesLease lease;
    private String constructionSite;
}
