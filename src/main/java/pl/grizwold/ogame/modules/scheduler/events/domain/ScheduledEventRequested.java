package pl.grizwold.ogame.modules.scheduler.events.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.grizwold.ogame.common.domain.Event;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ScheduledEventRequested extends Event {
    private LocalDateTime finishDate;

    public ScheduledEventRequested(Event event, LocalDateTime finishDate) {
        super(event);
        this.finishDate = finishDate;
    }
}
