package com.shestakam.tapestry.helloApp.pages;

import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.RequestParameter;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by alexandr on 12/30/15.
 */
public class AdressQuery {

    @Property
    @Persist
    @ActivationRequestParameter("name")
    private String name;

    @Property
    //@ActivationRequestParameter("adress")
    private String adress;

  /*  public void setup(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }*/

    void onActivate(@RequestParameter("name") String username) throws Exception {
        SecureRandom random = new SecureRandom();
        this.adress = new BigInteger(130, random).toString(32);
        this.name = username;
    }

}
