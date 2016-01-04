package com.shestakam.tapestry.helloApp.pages;

import com.shestakam.tapestry.helloApp.entities.User;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

/**
 * Created by alexandr on 12/30/15.
 */
public class HelloUser {

    @Property
    @Persist
    private User user;

    @InjectPage
    private Address address;

    public void setup(User user) {
        this.user = user;
    }

   /* Object onActionFromAdress(String username)
    {
        SecureRandom random = new SecureRandom();
       // address.setup(username, new BigInteger(130, random).toString(32));
        return address;
    }*/

}
