package pl.grizwold.ogame.modules.resources.events.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.resources.domain.Cost;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ResourcesLeaseRequested extends Event {
    private Cost cost;
    private String planetId;

    public ResourcesLeaseRequested(Event event, Cost cost, String planetId) {
        super(event);
        this.cost = cost;
        this.planetId = planetId;
    }
}
