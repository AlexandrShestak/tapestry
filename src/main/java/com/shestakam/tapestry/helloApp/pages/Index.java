package com.shestakam.tapestry.helloApp.pages;

import com.shestakam.tapestry.helloApp.entities.User;
import org.apache.tapestry5.annotations.*;

/**
 * Created by alexandr on 12/30/15.
 */
public class Index {

    @InjectPage
    private HelloUser helloUser;

    @Property
    private User user;

    @PageLoaded
    void beforeLoad() {
        user = new User();
    }

    Object onSuccess() {
        helloUser.setup(user);
        return helloUser;
    }

}
