package pl.grizwold.ogame.modules.resources.events.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ResourceLeaseUsed extends Event {
    private String resourcesLeaseId;

    public ResourceLeaseUsed(Event event, String resourcesLeaseId) {
        super(event);
        this.resourcesLeaseId = resourcesLeaseId;
    }
}
