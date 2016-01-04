package com.shestakam.tapestry.helloApp.services.user;

import com.shestakam.tapestry.helloApp.entities.User;

/**
 * Created by alexandr on 1/4/16.
 */
public interface IUserService {

    Long saveUser(User user);
    User getUser(String name);
    void addAddressToUser(String username, String addressName);

}
