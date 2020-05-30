package org.spaceappschallenge.purifyairsupply.core;

public interface ListenerFactory {

    Listener getInstance(Runnable action);
}
