package pl.grizwold.ogame.modules.buildings.dao;

import org.springframework.data.repository.Repository;
import pl.grizwold.ogame.modules.buildings.domain.ConstructionSite;

import java.util.UUID;

public interface ConstructionSiteDao extends Repository<ConstructionSite, UUID> {
    void save(ConstructionSite constructionSite);
}
