package net.vibro.app.service;

import net.vibro.app.Dao.RoleDao;
import net.vibro.app.Dao.UserDao;
import net.vibro.app.model.Role;
import net.vibro.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ${Mirek} on 26.03.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add((Role) roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);

    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
