package org.spaceappschallenge.purifyairsupply.core.raspberrypi.impl;

import org.spaceappschallenge.purifyairsupply.core.Listener;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RaspberryPiListenerImpl implements GpioPinListenerDigital, Listener {

    private final Runnable action;

    @Override
    public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        action.run();
    }
}
