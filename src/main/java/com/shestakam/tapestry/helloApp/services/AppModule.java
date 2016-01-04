package com.shestakam.tapestry.helloApp.services;

import com.shestakam.tapestry.helloApp.services.cayenne.CayenneService;
import com.shestakam.tapestry.helloApp.services.cayenne.ICayenneService;
import com.shestakam.tapestry.helloApp.services.user.IUserService;
import com.shestakam.tapestry.helloApp.services.user.UserService;
import org.apache.tapestry5.ioc.ServiceBinder;

public class AppModule {

  public static void bind(ServiceBinder binder) {
    binder.bind(ICayenneService.class, CayenneService.class);
    binder.bind(IUserService.class, UserService.class);
  }
}