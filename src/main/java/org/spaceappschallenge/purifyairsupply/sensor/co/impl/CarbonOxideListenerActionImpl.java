package org.spaceappschallenge.purifyairsupply.sensor.co.impl;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.spaceappschallenge.purifyairsupply.sensor.co.CarbonOxideListenerAction;
import org.spaceappschallenge.purifyairsupply.sensor.co.CarbonOxideSensor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CarbonOxideListenerActionImpl implements CarbonOxideListenerAction {

    @Getter
    private final int pin;
    private final CarbonOxideSensor carbonOxideSensor;

    public CarbonOxideListenerActionImpl(@Value("${sensor.co.pin}") int pin,
                                         CarbonOxideSensor carbonOxideSensor) {
        this.pin = pin;
        this.carbonOxideSensor = carbonOxideSensor;
    }

    @Override
    public void run() {
        carbonOxideSensor.registerEvent();
    }
}
