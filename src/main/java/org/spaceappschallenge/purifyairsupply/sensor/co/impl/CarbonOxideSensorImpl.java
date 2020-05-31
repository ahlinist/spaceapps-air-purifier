package org.spaceappschallenge.purifyairsupply.sensor.co.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spaceappschallenge.purifyairsupply.event.Event;
import org.spaceappschallenge.purifyairsupply.event.EventBus;
import org.spaceappschallenge.purifyairsupply.sensor.co.CarbonOxideSensor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CarbonOxideSensorImpl implements CarbonOxideSensor {

    private final EventBus eventBus;

    @Override
    public void registerEvent() {
        log.info("Carbon dioxide detected!");
        eventBus.addEvent(Event.CO_DETECTED);
    }
}
