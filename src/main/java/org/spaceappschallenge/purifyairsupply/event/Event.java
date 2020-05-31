package org.spaceappschallenge.purifyairsupply.event;

import lombok.Getter;

@Getter
public enum Event {
    CO_DETECTED(true);

    Event(boolean includeAlarm) {
        this.includeAlarm = includeAlarm;
    }

    boolean includeAlarm;
    boolean includeLed;
    boolean turnOnFan;
}
