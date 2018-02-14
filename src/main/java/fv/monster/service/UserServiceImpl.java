package fv.monster.service;

import fv.monster.dto.UserDto;
import fv.monster.exception.UserAlreadyExistsException;
import fv.monster.model.Role;
import fv.monster.model.User;
import fv.monster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public User addUser(UserDto userDto) {
        User foundUser = userRepository.findOneByEmail(userDto.getEmail());
        if (foundUser != null) {
            throw new UserAlreadyExistsException();
        }

        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setActivated(true);
        user.setActivationHash(UUID.randomUUID().toString());

        List<Role> roles = new ArrayList<>();
        roles.add(roleService.createOrGetRoleUser());
        user.setRoles(roles);

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository.findOneByEmail(username);
        if (foundUser == null) {
            throw new UsernameNotFoundException("USER_NOT_FOUND");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : foundUser.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(username, foundUser.getPassword(), true, true,
                true, foundUser.isActivated(), grantedAuthorities);
    }

}
