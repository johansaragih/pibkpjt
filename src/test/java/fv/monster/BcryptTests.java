package fv.monster;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author davidtobing -- fv.davidtobing@gmail.com
 */
public class BcryptTests {
    
//    @Test
//    public void test_Bcryptoon_Same() {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String password = "admin";
//        String hash = "$2a$10$6Y90YIk959YxlEy71WguB.7yKG/hZE5YQrd7t9pe8Wul97TbXpSGm";
//        
//        System.out.println("--------------------");
//        Assert.assertTrue(encoder.matches(password, hash));
//    }
    
    @Test
    public void test_Bcryptoon_Create() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "admin123";
        
        System.out.println("--------------------");
        String hash = encoder.encode(password);
        System.out.println("Hash : " + hash);
        
        // to hash password
        Assert.assertNotNull(hash);
    }

}