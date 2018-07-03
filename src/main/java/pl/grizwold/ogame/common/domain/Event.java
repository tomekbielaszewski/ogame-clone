package pl.grizwold.ogame.common.domain;

import java.util.UUID;

public abstract class Event {
    protected String ownerId;
    protected UUID uuid;
    protected long timestamp;
}
