package pl.grizwold.ogame.modules.scheduler.events.listeners;

import org.springframework.context.event.EventListener;
import pl.grizwold.ogame.common.domain.Event;
import pl.grizwold.ogame.modules.scheduler.events.domain.ScheduledEventRequested;

import java.time.LocalDateTime;

public class ScheduledEventRequestedListener {

    @EventListener(ScheduledEventRequested.class)
    public void execute(ScheduledEventRequested event) {
        saveScheduledEvent(event.getEvent(), event.getFinishDate());
    }

    private void saveScheduledEvent(Event event, LocalDateTime finishDate) {
        //save event in module-private DB
    }
}
