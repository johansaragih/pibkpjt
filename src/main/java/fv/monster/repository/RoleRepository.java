package fv.monster.repository;

import fv.monster.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findOneByName(String name);
}