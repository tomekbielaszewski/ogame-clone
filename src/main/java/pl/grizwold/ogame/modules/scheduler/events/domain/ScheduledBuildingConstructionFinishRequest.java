package pl.grizwold.ogame.modules.scheduler.events.domain;

import lombok.Value;
import pl.grizwold.ogame.common.domain.Event;

import java.time.LocalDateTime;

@Value
public class ScheduledBuildingConstructionFinishRequest extends Event {
    private LocalDateTime finishDate;
    private String constructionSiteId;
}
