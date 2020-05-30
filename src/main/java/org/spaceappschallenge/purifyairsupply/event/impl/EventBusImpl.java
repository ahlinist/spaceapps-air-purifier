package org.spaceappschallenge.purifyairsupply.event.impl;

import org.spaceappschallenge.purifyairsupply.event.Event;
import org.spaceappschallenge.purifyairsupply.event.EventBus;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class EventBusImpl implements EventBus {

    private final LinkedList<Event> events = new LinkedList<>();

    @Override
    public void addEvent(Event event) {
        this.events.add(event);
    }

    @Override
    public Event getNext() {
        if (events.isEmpty()) {
            return null;
        } else {
            Event event = events.pop();
            events.clear();
            return event;
        }
    }
}
