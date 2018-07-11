package pl.grizwold.ogame.modules.resources.events.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.resources.domain.Cost;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BuildingConstructionResourcesLeaseRequested extends Event {
    private String constructionSiteId;
    private Cost cost;
    private String planetId;

    public BuildingConstructionResourcesLeaseRequested(Event event, String constructionSiteId, Cost cost, String planetId) {
        super(event);
        this.constructionSiteId = constructionSiteId;
        this.cost = cost;
        this.planetId = planetId;
    }
}
