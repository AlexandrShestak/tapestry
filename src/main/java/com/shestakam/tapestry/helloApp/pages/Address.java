package com.shestakam.tapestry.helloApp.pages;

import com.shestakam.tapestry.helloApp.entities.User;
import com.shestakam.tapestry.helloApp.services.user.IUserService;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.InjectService;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by alexandr on 12/30/15.
 */
public class Address {

    @Property
    private String name;

    @Property
    private String address;

    @InjectPage
    private Error error;


    @Inject
    private IUserService userService;


    Error onActivate() throws Exception {
        return error;
    }

    Object onActivate(String username) throws Exception {
        User user = userService.getUser(username);
        if (user == null) {
            return error;
        }
        if (user.getAddress().isEmpty()) {
            SecureRandom random = new SecureRandom();
            userService.addAddressToUser(user.getName(),  new BigInteger(130, random).toString(32));
        }

        User userWithAddress = userService.getUser(username);

        this.address = user.getAddress().get(0).getName();
        this.name = user.getName();
        return true;
    }



}
