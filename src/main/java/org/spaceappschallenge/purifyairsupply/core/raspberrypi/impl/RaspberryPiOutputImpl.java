package org.spaceappschallenge.purifyairsupply.core.raspberrypi.impl;

import org.spaceappschallenge.purifyairsupply.core.Output;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class RaspberryPiOutputImpl implements Output {

    private final long interval;
    private final GpioPinDigitalOutput gpioPinDigitalOutput;

    @Override
    @SneakyThrows
    public void pulse() {
        gpioPinDigitalOutput.pulse(interval);
    }
}
