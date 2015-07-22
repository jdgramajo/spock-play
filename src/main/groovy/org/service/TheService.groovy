package org.service

class TheService {

	int slowMethod() {
	  sleep(3000)
	  println 'I was asleep three seconds'
	  3000
	}

	int normalMethod() {
	  sleep(1000)
	  println 'I was asleep one second'
	  1000
	}

	int fastMethod() {
	  println 'I never slept'
	  0
	}

}
