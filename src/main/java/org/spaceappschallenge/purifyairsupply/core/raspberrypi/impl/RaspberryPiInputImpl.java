package org.spaceappschallenge.purifyairsupply.core.raspberrypi.impl;

import org.spaceappschallenge.purifyairsupply.core.Input;
import org.spaceappschallenge.purifyairsupply.core.Listener;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RaspberryPiInputImpl implements Input {

    private final GpioPinDigitalInput gpioPinDigitalInput;

    @Override
    public void addListener(Listener listener) {
        GpioPinListenerDigital gpioListener = (GpioPinListenerDigital) listener;
        gpioPinDigitalInput.addListener(gpioListener);
    }
}
