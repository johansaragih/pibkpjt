package fv.monster.repository;

import fv.monster.model.Captcha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@Repository
public interface CaptchaRepository extends JpaRepository<Captcha, Long> {

}
