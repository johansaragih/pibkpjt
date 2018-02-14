
package fv.monster.controller;

import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IndexController {
    
    // err: java.lang.String cannot be cast to org.springframework.security.core.userdetails.User
    // @GetMapping("/username")
    // @ResponseBody
    // public User me() {
    //     User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //     return user;
    // }
    
    @GetMapping("/usernameprincipal")
    @ResponseBody
    public String mex(Principal principal) {
        return principal.getName();
    }
    
//    --- or can be like this
    @GetMapping("/usernameauth")
    @ResponseBody
    public Authentication currentUserName(Authentication authentication) {
        // return authentication.getName();
        return authentication;
    }
    
//    only username
//    @GetMapping("/username")
//    @ResponseBody
//    public String me() {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return user.getUsername();
//    }

}
