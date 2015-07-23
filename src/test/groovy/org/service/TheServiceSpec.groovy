package org.service

import spock.lang.Specification
import spock.lang.Shared
import spock.lang.IgnoreIf

import org.annotations.*

//Group 'papi' and 'stamp'
@IgnoreIf({ !System.getProperty("intTest.single", "TheServiceSpec").contains("TheServiceSpec") })
class TheServiceSpec extends Specification {

	@Shared ts = new TheService()

	@IgnoreIf({ !System.getProperty("issue", "TRNK-SLOW").contains("TRNK-SLOW") || 
		!System.getProperty("groupName", "papi").contains("papi") })
	void "test the slow method"() {
		expect:
			ts.slowMethod() == 3000
	}

	@IgnoreIf({ !System.getProperty("issue", "TRNK-NORMAL").contains("TRNK-NORMAL") || 
		!System.getProperty("groupName", "stamp").contains("stamp") })
	void "test the normal method"() {
		expect:
			ts.normalMethod() == 1000
	}

	@IgnoreIf({ !System.getProperty("issue", "TRNK-FAST").contains("TRNK-FAST") || 
		(!System.getProperty("groupName", "papi").contains("papi") && 
		!System.getProperty("groupName", "stamp").contains("stamp")) })
	void "test the fast method"() {
		expect:
			ts.fastMethod() == 0
	}

}