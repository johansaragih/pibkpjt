package fv.monster.dto;

import fv.monster.model.Captcha;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
public class UserDto {

    @NotEmpty
//    @Email
    private String username;
    @Size(min = 5, max = 50)
    private String password;
    @NotEmpty
    @Size(max = 100)
    private String companyName;
    @NotEmpty
    @Size(max = 100)
    private String  token;
    @NotEmpty
    private String npwp;
    @NotNull
    private Captcha captcha;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public Captcha getCaptcha() {
        return captcha;
    }

    public void setCaptcha(Captcha captcha) {
        this.captcha = captcha;
    }
}
