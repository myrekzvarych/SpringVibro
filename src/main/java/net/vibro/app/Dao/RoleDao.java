package net.vibro.app.Dao;

import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ${Mirek} on 26.03.2017.
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}
