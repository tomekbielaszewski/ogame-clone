package pl.grizwold.ogame.modules.buildings.events.construction.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BuildingConstructionFinished extends Event {
    private final String resourcesLeaseId;
    private final String constructionSiteId;

    public BuildingConstructionFinished(Event event, String resourcesLeaseId, String constructionSiteId) {
        super(event);
        this.resourcesLeaseId = resourcesLeaseId;
        this.constructionSiteId = constructionSiteId;
    }
}
