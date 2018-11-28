package pl.grizwold.ogame.modules.resources.client;

import org.springframework.stereotype.Service;
import pl.grizwold.ogame.modules.resources.domain.Cost;

@Service
public class ResourcesReadService {
    public boolean hasEnoughResources(Cost cost, String planetId) {
        return false;
    }
}
