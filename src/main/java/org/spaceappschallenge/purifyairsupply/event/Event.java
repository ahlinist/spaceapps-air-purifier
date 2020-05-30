package org.spaceappschallenge.purifyairsupply.event;

import lombok.Getter;

public enum Event {
    CO_DETECTED(true);

    Event(boolean includeAlarm) {
        this.includeAlarm = includeAlarm;
    }

    @Getter
    boolean includeAlarm;
}
