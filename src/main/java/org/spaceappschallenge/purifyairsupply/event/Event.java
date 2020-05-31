package org.spaceappschallenge.purifyairsupply.event;

import lombok.Getter;

@Getter
public enum Event {
    CO_DETECTED(true, true, true);

    Event(boolean includeAlarm, boolean includeLed, boolean turnOnFan) {
        this.includeAlarm = includeAlarm;
        this.includeLed = includeLed;
        this.turnOnFan = turnOnFan;
    }

    boolean includeAlarm;
    boolean includeLed;
    boolean turnOnFan;
}
