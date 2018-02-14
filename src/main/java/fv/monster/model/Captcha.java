package fv.monster.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@Entity
@Data
public class Captcha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String captcha;
    private Date createDate;
}
