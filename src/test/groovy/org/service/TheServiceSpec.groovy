package org.service

import spock.lang.Specification
import spock.lang.Shared
import spock.lang.IgnoreIf

//Group 'papi' and 'stamp'
@IgnoreIf({ System.getProperty("intTest.single")?!System.getProperty("intTest.single").find(/TheServiceSpec/):null })
class TheServiceSpec extends Specification {

	static final issue = System.getProperty("issue")
	static final groupName = System.getProperty("groupName")

	@Shared ts = new TheService()

	@IgnoreIf({ !((!issue && !groupName) || issue =~ /TRNK-SLOW/ || groupName =~ /papi/) })
	void "test the slow method"() {
		expect:
			ts.slowMethod() == 3000
	}

	@IgnoreIf({ !((!issue && !groupName) || issue =~ /TRNK-NORMAL/ || groupName =~ /stamp/) })
	void "test the normal method"() {
		expect:
			ts.normalMethod() == 1000
	}

	@IgnoreIf({ !((!issue && !groupName) || issue =~ /TRNK-FAST/ || groupName =~ /papi|stamp/) })
	void "test the fast method"() {
		expect:
			ts.fastMethod() == 0
	}

}