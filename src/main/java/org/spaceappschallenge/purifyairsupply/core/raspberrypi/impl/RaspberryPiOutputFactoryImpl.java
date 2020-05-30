package org.spaceappschallenge.purifyairsupply.core.raspberrypi.impl;

import org.spaceappschallenge.purifyairsupply.core.Output;
import org.spaceappschallenge.purifyairsupply.core.OutputFactory;
import org.spaceappschallenge.purifyairsupply.core.raspberrypi.RaspberryPiPinMapping;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RaspberryPiOutputFactoryImpl implements OutputFactory {

    private static final PinState STATE = PinState.LOW;

    private final long interval;
    private final GpioController gpioController;

    public RaspberryPiOutputFactoryImpl(@Value("${operations.interval}") long interval, GpioController gpioController) {
        this.interval = interval;
        this.gpioController = gpioController;
    }

    @Override
    public Output getInstance(int pinNumber) {
        Pin pin = RaspberryPiPinMapping.PIN_MAPPING.get(pinNumber);
        GpioPinDigitalOutput gpioOutput = gpioController.provisionDigitalOutputPin(pin, STATE);
        return new RaspberryPiOutputImpl(interval, gpioOutput);
    }
}
