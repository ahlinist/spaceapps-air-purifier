package org.spaceappschallenge.purifyairsupply.processor;

import org.spaceappschallenge.purifyairsupply.event.Event;

public interface Processor {

    void processEvent(Event event);
}
