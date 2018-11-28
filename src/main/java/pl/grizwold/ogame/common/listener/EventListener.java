package pl.grizwold.ogame.common.listener;

import org.springframework.beans.factory.annotation.Autowired;
import pl.grizwold.ogame.common.dao.EventDao;
import pl.grizwold.ogame.common.domain.Event;

public class EventListener {
    private EventDao eventDao;

    @Autowired
    public EventListener(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @org.springframework.context.event.EventListener(Event.class)
    public void execute(Event event) {
        eventDao.save(event);
    }
}
