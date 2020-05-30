package org.spaceappschallenge.purifyairsupply.core.raspberrypi.impl;

import org.spaceappschallenge.purifyairsupply.core.Input;
import org.spaceappschallenge.purifyairsupply.core.InputFactory;
import org.spaceappschallenge.purifyairsupply.core.raspberrypi.RaspberryPiPinMapping;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RaspberryPiInputFactoryImpl implements InputFactory {

    private static final PinPullResistance RESISTANCE = PinPullResistance.PULL_DOWN;

    private final GpioController gpioController;

    @Override
    public Input getInstance(int pinNumber) {
        Pin pin = RaspberryPiPinMapping.PIN_MAPPING.get(pinNumber);
        GpioPinDigitalInput gpioInput = gpioController.provisionDigitalInputPin(pin, RESISTANCE);
        return new RaspberryPiInputImpl(gpioInput);
    }
}
