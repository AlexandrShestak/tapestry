package com.shestakam.tapestry.helloApp.entities;

/**
 * Created by alexandr on 12/30/15.
 */
public class User {

    private String name;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
