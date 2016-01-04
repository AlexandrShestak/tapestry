package com.shestakam.tapestry.helloApp.services.cayenne;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.di.Binder;
import org.apache.cayenne.di.Module;
import org.apache.tapestry5.ioc.services.RegistryShutdownHub;



public class CayenneService implements ICayenneService {

	protected ServerRuntime runtime;
	private ObjectContext sharedContext;

	public CayenneService(RegistryShutdownHub shutdownHub) {

		Module module = new Module() {
			public void configure(Binder binder) {

			}
		};

		this.runtime = new ServerRuntime("cayenne-tapestryHello.xml", module);
		this.sharedContext = runtime.newContext();

		shutdownHub.addRegistryShutdownListener(new Runnable() {

			public void run() {
				runtime.shutdown();
			}
		});
	}

	public ObjectContext sharedContext() {
		return sharedContext;
	}

	public ObjectContext newContext() {
		return runtime.newContext();
	}

}