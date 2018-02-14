package fv.monster.service;

import fv.monster.dto.CaptchaDto;
import fv.monster.model.Captcha;

public interface CaptchaService {

    CaptchaDto createCaptcha();

    boolean isCaptchaValid(Captcha captcha);
}
