package pl.grizwold.ogame.modules.scheduler.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;

@Value
public class ScheduledEvent {
    private long finishTimestamp;
    private Event event;
}
