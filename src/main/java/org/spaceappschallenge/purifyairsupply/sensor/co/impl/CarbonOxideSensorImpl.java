package org.spaceappschallenge.purifyairsupply.sensor.co.impl;

import lombok.extern.slf4j.Slf4j;
import org.spaceappschallenge.purifyairsupply.sensor.co.CarbonOxideSensor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CarbonOxideSensorImpl implements CarbonOxideSensor {

    @Override
    public void registerEvent() {
        System.out.println("Carbon dioxide detected!");
    }
}
