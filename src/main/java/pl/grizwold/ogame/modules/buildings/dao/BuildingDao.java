package pl.grizwold.ogame.modules.buildings.dao;

import org.springframework.data.repository.Repository;
import pl.grizwold.ogame.modules.buildings.domain.Building;
import pl.grizwold.ogame.modules.buildings.domain.BuildingType;

import java.util.Optional;
import java.util.UUID;

public interface BuildingDao extends Repository<Building, UUID> {
    Optional<Building> findByTypeAndPlanetId(BuildingType type, String planetId);
}
