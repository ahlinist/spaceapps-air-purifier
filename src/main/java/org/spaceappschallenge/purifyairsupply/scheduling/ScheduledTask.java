package org.spaceappschallenge.purifyairsupply.scheduling;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spaceappschallenge.purifyairsupply.audio.AudioPlayer;
import org.spaceappschallenge.purifyairsupply.event.Event;
import org.spaceappschallenge.purifyairsupply.event.EventBus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduledTask {

    private static final String ALARM_RESOURCE_PATH = "audio/alarm.wav";

    private final EventBus eventBus;
    private final AudioPlayer audioPlayer;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz");
        String formattedString = LocalDate.now().format(formatter);
        log.info("Heartbeat: {}", formattedString);
        Event event = eventBus.getNext();

        if (event != null && event.isIncludeAlarm()) {
            audioPlayer.play(ALARM_RESOURCE_PATH);
        }
    }
}
