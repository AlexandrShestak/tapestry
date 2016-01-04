package com.shestakam.tapestry.helloApp.services;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import com.shestakam.tapestry.helloApp.entities.User;

public class Main {

    public static void main(String[] args) {
        ServerRuntime cayenneRuntime = new ServerRuntime(
                "cayenne-tapestryHello.xml");
        ObjectContext context = cayenneRuntime.newContext();

        User user = context.newObject(User.class);
        user.setName("Petr");
        user.setPassword("12345678");
        context.commitChanges();

    }
}