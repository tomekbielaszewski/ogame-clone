package pl.grizwold.ogame.modules.resources.events.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BuildingConstructionResourcesLeased extends Event {
    private String resourceLeaseId;
    private String constructionSiteId;

    public BuildingConstructionResourcesLeased(Event event, String resourceLeaseId, String constructionSiteId) {
        super(event);
        this.resourceLeaseId = resourceLeaseId;
        this.constructionSiteId = constructionSiteId;
    }
}
