package pl.grizwold.ogame.common.dao;

import org.springframework.data.repository.Repository;
import pl.grizwold.ogame.common.domain.Event;

import java.util.UUID;

public interface EventDao extends Repository<Event, UUID> {
    void save(Event event);
}
