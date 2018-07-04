package pl.grizwold.ogame.modules.buildings.domain;

import lombok.Getter;
import pl.grizwold.ogame.modules.resources.domain.Cost;

@Getter
public enum BuildingType {
    METAL_MINE(cost()),
    CRYSTAL_MINE(cost()),
    DEUTERIUM_EXTRACTOR(cost()),
    SOLAR_POWER_PLANT(cost()),
    FUSION_REACTOR(cost()),
    ROBOTICS_FACTORY(cost()),
    NANITE_FACTORY(cost()),
    SHIPYARD(cost()),
    METAL_STORAGE(cost()),
    CRYSTAL_STORAGE(cost()),
    DEUTERIUM_TANK(cost()),
    LABORATORY(cost()),
    TERRAFORMER(cost()),
    ALLIANCE_DEPOSIT(cost()),
    MISSILE_SILO(cost());

    private final Cost baseCost;

    BuildingType(Cost baseCost) {
        this.baseCost = baseCost;
    }

    private static Cost cost() {
        return new Cost(1,1,1);
    }
}
