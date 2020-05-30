package org.spaceappschallenge.purifyairsupply.sensor

import org.spaceappschallenge.purifyairsupply.sensor.co.CarbonOxideListenerAction
import org.spaceappschallenge.purifyairsupply.sensor.co.CarbonOxideSensor
import org.spaceappschallenge.purifyairsupply.sensor.co.impl.CarbonOxideListenerActionImpl
import spock.lang.Specification
import spock.lang.Subject

class CarbonOxideListenerActionSpec extends Specification {

    Integer pin = 1
    CarbonOxideSensor carbonOxideSensor = Mock CarbonOxideSensor

    @Subject
    CarbonOxideListenerAction action = new CarbonOxideListenerActionImpl(pin, carbonOxideSensor)

    def 'test run()'() {
        when:
        action.run()

        then:
        1 * carbonOxideSensor.registerEvent()
        0 * _
    }
}
