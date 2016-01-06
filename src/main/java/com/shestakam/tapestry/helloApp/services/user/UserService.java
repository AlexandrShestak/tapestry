package com.shestakam.tapestry.helloApp.services.user;

import com.shestakam.tapestry.helloApp.entities.Address;
import com.shestakam.tapestry.helloApp.entities.User;
import com.shestakam.tapestry.helloApp.services.cayenne.ICayenneService;
import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.SelectQuery;
import org.apache.tapestry5.ioc.annotations.Inject;


import java.util.List;

/**
 * Created by alexandr on 1/4/16.
 */
public class UserService implements IUserService {

    @Inject
    private ICayenneService cayenneService;

    public Long saveUser(User user) {
        ObjectContext objectContext = cayenneService.sharedContext();
        User userTemp = objectContext.newObject(User.class);
        userTemp.setName(user.getName());
        userTemp.setPassword(user.getPassword());
        objectContext.commitChanges();
        long pk = Cayenne.longPKForObject(userTemp);
        return pk;

    }

    public User getUser(String name) {
        ObjectContext objectContext = cayenneService.sharedContext();
        Expression expression = ExpressionFactory.likeIgnoreCaseExp(
                User.NAME_PROPERTY,
                name);
        SelectQuery select2 = new SelectQuery(User.class, expression);
        List list = objectContext.performQuery(select2);
        if (list.isEmpty()) {
            return null;
        }
        User user = (User) list.get(0);
        objectContext.commitChanges();
        return user;
    }

    public void addAddressToUser(String username, String addressName) {

        ObjectContext objectContext = cayenneService.sharedContext();
        Address address = objectContext.newObject(Address.class);
        address.setName(addressName);
        objectContext.commitChanges();


        User user = getUser(username);
        //user.getAddress().add(address);
        user.addToAddress(address);
        objectContext.commitChanges();
    }
}
