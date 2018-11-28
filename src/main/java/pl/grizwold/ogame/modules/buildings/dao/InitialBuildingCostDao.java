package pl.grizwold.ogame.modules.buildings.dao;

import org.springframework.data.repository.Repository;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;
import pl.grizwold.ogame.modules.buildings.domain.InitialBuildingCost;

import java.util.UUID;

public interface InitialBuildingCostDao extends Repository<InitialBuildingCost, UUID> {
    InitialBuildingCost getByBuildingType(BuildingType type);
}
