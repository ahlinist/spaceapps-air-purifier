package org.spaceappschallenge.purifyairsupply

import org.springframework.boot.ApplicationArguments
import spock.lang.Specification
import spock.lang.Subject

class PurifyAirSupplyApplicationSpec extends Specification {

	@Subject
	PurifyAirSupplyApplication purifyAirSupplyApplication = new PurifyAirSupplyApplication()

	def "test run()"() {
		when:
		purifyAirSupplyApplication.run(_ as ApplicationArguments)

		then:
		0 * _
	}
}
