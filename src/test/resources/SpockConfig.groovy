runner {
	if(System.getProperty("groupName")?.contains("Papi")) {
		logger.lifecycle 'Including Papi and excluding Stamp'
		exclude Stamp
		include Papi
	}
}