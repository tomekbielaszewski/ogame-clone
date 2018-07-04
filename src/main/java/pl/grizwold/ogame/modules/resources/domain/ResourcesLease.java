package pl.grizwold.ogame.modules.resources.domain;

import lombok.Value;

@Value
public class ResourcesLease {
    private int metal;
    private int crystal;
    private int deuterium;

    private String planetId;
}
