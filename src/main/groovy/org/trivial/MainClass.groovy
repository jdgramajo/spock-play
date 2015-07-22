package org.trivial

import org.service.TheService

def ts = new TheService()
ts.fastMethod()
ts.normalMethod()
ts.slowMethod()