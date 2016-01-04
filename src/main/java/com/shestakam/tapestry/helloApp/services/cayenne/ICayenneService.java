package com.shestakam.tapestry.helloApp.services.cayenne;

import org.apache.cayenne.ObjectContext;

public interface ICayenneService {

	ObjectContext sharedContext();

	ObjectContext newContext();
}