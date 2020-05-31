package org.spaceappschallenge.purifyairsupply.processor;

import org.spaceappschallenge.purifyairsupply.event.Event;

public interface EventProcessor {

    void process(Event event);
}
