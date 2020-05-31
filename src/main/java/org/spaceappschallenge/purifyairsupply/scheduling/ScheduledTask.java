package org.spaceappschallenge.purifyairsupply.scheduling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spaceappschallenge.purifyairsupply.event.Event;
import org.spaceappschallenge.purifyairsupply.event.EventBus;
import org.spaceappschallenge.purifyairsupply.processor.EventProcessor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduledTask {

    private final EventBus eventBus;
    private final EventProcessor eventProcessor;

    @Scheduled(fixedRate = 1000)
    public void checkForEvents() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedString = now.format(formatter);
        log.info("Heartbeat: {}", formattedString);
        Event event = eventBus.getNext();

        if (event != null) {
            eventProcessor.process(event);
        }
    }
}
