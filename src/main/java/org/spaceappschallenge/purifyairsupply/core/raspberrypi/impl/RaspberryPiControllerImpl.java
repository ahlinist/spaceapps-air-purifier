package org.spaceappschallenge.purifyairsupply.core.raspberrypi.impl;

import org.spaceappschallenge.purifyairsupply.core.*;
import org.spaceappschallenge.purifyairsupply.sensor.ListenerAction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RaspberryPiControllerImpl implements Controller {

    private final InputFactory inputFactory;
    private final OutputFactory outputFactory;
    private final ListenerFactory listenerFactory;
    private final List<ListenerAction> inputActions;

    @Override
    public void init() {
        inputActions.stream()
                .forEach(action -> this.initInput(action.getPin(), action));
    }

    @Override
    public Input initInput(int pinNumber, Runnable action) {
        Listener listener = listenerFactory.getInstance(action);
        Input input = inputFactory.getInstance(pinNumber);
        input.addListener(listener);
        return input;
    }

    @Override
    public Output initOutput(int pinNumber) {
        return outputFactory.getInstance(pinNumber);
    }
}
