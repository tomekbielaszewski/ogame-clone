package pl.grizwold.ogame.common.domain;

import lombok.Getter;

@Getter
public abstract class Event {
    protected final String ownerId;
    protected final String correlationToken;

    protected Event(String ownerId, String correlationToken) {
        this.ownerId = ownerId;
        this.correlationToken = correlationToken;
    }

    protected Event(Event event) {
        this.ownerId = event.ownerId;
        this.correlationToken = event.correlationToken;
    }
}
