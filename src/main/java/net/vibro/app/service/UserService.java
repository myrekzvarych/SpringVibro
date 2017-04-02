package net.vibro.app.service;

import net.vibro.app.model.User;

/**
 * Created by ${Mirek} on 26.03.2017.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);

}
