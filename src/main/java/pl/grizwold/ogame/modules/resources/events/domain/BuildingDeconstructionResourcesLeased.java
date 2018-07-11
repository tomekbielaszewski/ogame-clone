package pl.grizwold.ogame.modules.resources.events.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BuildingDeconstructionResourcesLeased extends Event {
    private String resourceLeaseId;
    private String constructionSiteId;
    private String planetId;

    public BuildingDeconstructionResourcesLeased(Event event, String resourceLeaseId, String constructionSiteId, String planetId) {
        super(event);
        this.resourceLeaseId = resourceLeaseId;
        this.constructionSiteId = constructionSiteId;
        this.planetId = planetId;
    }
}
