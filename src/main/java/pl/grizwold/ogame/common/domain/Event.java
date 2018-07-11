package pl.grizwold.ogame.common.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Event {
    protected final String ownerId;
    protected final UUID uuid;

    public Event(String ownerId, UUID uuid) {
        this.ownerId = ownerId;
        this.uuid = uuid;
    }

    public Event(Event event) {
        this.ownerId = event.ownerId;
        this.uuid = event.uuid;
    }
}
