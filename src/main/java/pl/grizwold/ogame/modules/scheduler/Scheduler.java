package pl.grizwold.ogame.modules.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

class Scheduler {

    @Scheduled(fixedRate = 1000)
    void riseScheduledEvents() {
        //get all not raised events with finishDate in the past
        //raise every event on the list
        //update events as already raised
    }
}
