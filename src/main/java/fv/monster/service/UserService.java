package fv.monster.service;

import fv.monster.dto.UserDto;
import fv.monster.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
public interface UserService extends UserDetailsService {

    User addUser(UserDto userDto);

    User getUserById(Long id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(Long id);
}
