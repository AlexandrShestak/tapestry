package com.shestakam.tapestry.helloApp.pages;

import org.apache.tapestry5.annotations.*;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by alexandr on 12/30/15.
 */
public class AddressQuery {

    @Property
    @Persist
    @ActivationRequestParameter("name")
    private String name;

    @Property
    private String address;

    void onActivate(@RequestParameter("name") String username) throws Exception {
        SecureRandom random = new SecureRandom();
        this.address = new BigInteger(130, random).toString(32);
        this.name = username;
    }

}
