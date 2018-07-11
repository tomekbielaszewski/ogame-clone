package pl.grizwold.ogame.modules.buildings.events.destruction.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BuildingDeconstructionFinished extends Event {
    private String resourcesLeaseId;
    private String constructionSiteId;

    public BuildingDeconstructionFinished(Event event, String resourcesLeaseId, String constructionSiteId) {
        super(event);
        this.resourcesLeaseId = resourcesLeaseId;
        this.constructionSiteId = constructionSiteId;
    }
}
