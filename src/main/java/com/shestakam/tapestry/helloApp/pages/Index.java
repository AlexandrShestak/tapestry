package com.shestakam.tapestry.helloApp.pages;

import com.shestakam.tapestry.helloApp.entities.User;
import com.shestakam.tapestry.helloApp.services.user.IUserService;
import org.apache.cayenne.di.Inject;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.PageLoaded;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.InjectService;


/**
 * Created by alexandr on 12/30/15.
 */
public class Index {

    @InjectPage
    private HelloUser helloUser;

    @Property
    private User user;

    @InjectService(value = "IUserService")
    private IUserService userService;

    @PageLoaded
    void beforeLoad() {
        user = new User();
    }

    @Log
    Object onSuccess() {
        /*ServerRuntime cayenneRuntime = new ServerRuntime(
                "cayenne-tapestryHello.xml");
        ObjectContext context = cayenneRuntime.newContext();
        User userTemp = context.newObject(User.class);
        userTemp.setName(this.user.getName());
        userTemp.setPassword(this.user.getPassword());
        context.commitChanges();*/
        userService.saveUser(user);

        helloUser.setup(this.user);
        return helloUser;
    }

}
