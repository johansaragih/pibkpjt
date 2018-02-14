package fv.monster.controller;

import fv.monster.dto.UserDto;
import fv.monster.exception.InvalidCaptchaException;
import fv.monster.model.User;
import fv.monster.service.CaptchaService;
import fv.monster.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/api"})
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private CaptchaService captchaService;    
    
    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody UserDto userDto, HttpServletRequest request) {
        if (!captchaService.isCaptchaValid(userDto.getCaptcha())) {
            throw new InvalidCaptchaException();
        }

        userService.addUser(userDto);

//        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
        //userService.sendConfirmationEmailToUser(user, baseUrl);
    }

    @RequestMapping(value = "/users/confirm", method = RequestMethod.GET)
    public void confirmEmail(@RequestParam("h") String activationHash) {
        // userService.activateEmail(activationHash);
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/admin/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
