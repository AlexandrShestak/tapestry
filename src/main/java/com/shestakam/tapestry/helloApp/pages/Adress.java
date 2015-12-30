package com.shestakam.tapestry.helloApp.pages;

import org.apache.tapestry5.annotations.*;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by alexandr on 12/30/15.
 */
public class Adress {

    @Property
    private String name;

    @InjectPage
    private Error error;



    @Property
    //@ActivationRequestParameter("adress")
    private String adress;

  /*  public void setup(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }*/

    void onActivate(String username) throws Exception {
        SecureRandom random = new SecureRandom();
        this.adress = new BigInteger(130, random).toString(32);
        this.name = username;
    }

     Object onActivate() throws Exception {
        return error;
    }


}
