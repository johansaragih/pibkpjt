package fv.monster.service;

import fv.monster.model.Role;
import fv.monster.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        role.setId(null);
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.delete(id);
    }

    @Override
    public Role createOrGetRoleUser() {
        Role role = roleRepository.findOneByName("USER");
        if (role == null) {
            Role userRole = new Role();
            userRole.setName("USER");
            role = roleRepository.save(userRole);
        }
        return role;
    }
}
