package pl.grizwold.ogame.common.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

public abstract class Event {
    protected String ownerId;
    protected UUID uuid;
    protected long timestamp;
}
