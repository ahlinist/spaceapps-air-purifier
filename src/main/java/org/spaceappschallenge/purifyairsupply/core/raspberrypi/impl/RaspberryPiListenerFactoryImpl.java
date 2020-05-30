package org.spaceappschallenge.purifyairsupply.core.raspberrypi.impl;

import org.spaceappschallenge.purifyairsupply.core.Listener;
import org.spaceappschallenge.purifyairsupply.core.ListenerFactory;
import org.springframework.stereotype.Component;

@Component
public class RaspberryPiListenerFactoryImpl implements ListenerFactory {

    @Override
    public Listener getInstance(Runnable action) {
        return new RaspberryPiListenerImpl(action);
    }
}
