package pl.grizwold.ogame.modules.scheduler.events.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ScheduledEventFinished extends Event {
    public ScheduledEventFinished(String ownerId, String correlationToken) {
        super(ownerId, correlationToken);
    }
}
