package fv.monster.controller;

import fv.monster.dto.CaptchaDto;
import fv.monster.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/captcha")
public class CaptchaController {

    @Autowired
    CaptchaService captchaService;

    @RequestMapping("")
    public CaptchaDto getNewCaptcha() {
        return captchaService.createCaptcha();
    }
}
