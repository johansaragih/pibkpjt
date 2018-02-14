package fv.monster.service;

import fv.monster.model.Role;
import java.util.List;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
public interface RoleService {

    Role addRole(Role role);

    List<Role> getAllRoles();

    Role updateRole(Role role);

    void deleteRole(Long id);

    Role createOrGetRoleUser();
}
