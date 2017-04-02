package net.vibro.app.Dao;

import net.vibro.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ${Mirek} on 26.03.2017.
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
