package pl.grizwold.ogame.modules.resources.events.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;

@Value
public class ResourceLeaseUsed extends Event {
    private String resourcesLeaseId;
}
