package org.spaceappschallenge.purifyairsupply

import org.spaceappschallenge.purifyairsupply.core.Controller
import org.springframework.boot.ApplicationArguments
import spock.lang.Specification
import spock.lang.Subject

class PurifyAirSupplyApplicationSpec extends Specification {

	Controller controller = Mock Controller

	@Subject
	PurifyAirSupplyApplication purifyAirSupplyApplication = new PurifyAirSupplyApplication(controller)

	def "test run()"() {
		when:
		purifyAirSupplyApplication.run(_ as ApplicationArguments)

		then:
		1 * controller.init()
		0 * _
	}
}
