package org.service

import spock.lang.Specification
import spock.lang.Shared

class TheServiceSpec extends Specification {

	@Shared ts = new TheService()

	void "test the slow method"() {
		expect:
			ts.slowMethod() == 3000
	}

}