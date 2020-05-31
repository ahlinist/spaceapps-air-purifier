package org.spaceappschallenge.purifyairsupply.processor.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spaceappschallenge.purifyairsupply.audio.AudioPlayer;
import org.spaceappschallenge.purifyairsupply.core.Output;
import org.spaceappschallenge.purifyairsupply.event.Event;
import org.spaceappschallenge.purifyairsupply.processor.EventProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventProcessorImpl implements EventProcessor {

    private static final String ALARM_RESOURCE_PATH = "audio/alarm.wav";

    private final AudioPlayer audioPlayer;
    private final Output ledOutput;
    private final Output fanOutput;

    @Override
    public void process(Event event) {
        if (event.isIncludeAlarm()) {
            audioPlayer.play(ALARM_RESOURCE_PATH);
        }

        if (event.isIncludeLed()) {
            log.info("Turning on LED");
            ledOutput.pulse();
        }

        if (event.isTurnOnFan()) {
            log.info("Turning on fan");
            fanOutput.pulse();
        }
    }
}
