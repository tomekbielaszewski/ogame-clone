package pl.grizwold.ogame.modules.buildings.domain;

import lombok.Value;
import pl.grizwold.ogame.modules.resources.domain.Cost;

import java.math.BigDecimal;

@Value
public class InitialBuildingCost {
    private BuildingType buildingType;
    private Cost initialCost;
    private BigDecimal multiplier;
}
