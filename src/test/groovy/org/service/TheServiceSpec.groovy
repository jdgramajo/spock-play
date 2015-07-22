package org.service

import spock.lang.Specification
import spock.lang.Shared

class TheServiceSpec extends Specification {

	@Shared ts = new TheService()

	void "test the slow method"() {
		expect:
			ts.slowMethod() == 3000
	}

	void "test the normal method"() {
		expect:
			ts.normalMethod() == 1000
	}

	void "test the fast method"() {
		expect:
			ts.fastMethod() == 0
	}

}