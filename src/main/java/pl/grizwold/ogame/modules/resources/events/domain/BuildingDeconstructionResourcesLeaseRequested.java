package pl.grizwold.ogame.modules.resources.events.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.resources.domain.Cost;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BuildingDeconstructionResourcesLeaseRequested extends Event {
    private Cost cost;
    private String constructionSiteId;
    private String planetId;

    public BuildingDeconstructionResourcesLeaseRequested(Event event, Cost cost, String constructionSiteId, String planetId) {
        super(event);
        this.cost = cost;
        this.constructionSiteId = constructionSiteId;
        this.planetId = planetId;
    }
}
