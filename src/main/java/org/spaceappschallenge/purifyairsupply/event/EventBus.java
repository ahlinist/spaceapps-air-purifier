package org.spaceappschallenge.purifyairsupply.event;

public interface EventBus {

    void addEvent(Event event);

    Event getNext();
}
