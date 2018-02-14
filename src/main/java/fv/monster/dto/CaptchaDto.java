package fv.monster.dto;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
public class CaptchaDto {

    private Long id;
    private byte[] captchaImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getCaptchaImage() {
        return captchaImage;
    }

    public void setCaptchaImage(byte[] captchaImage) {
        this.captchaImage = captchaImage;
    }
}
