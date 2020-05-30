package org.spaceappschallenge.purifyairsupply.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("Heartbeat: {}", LocalDate.now());
    }
}
