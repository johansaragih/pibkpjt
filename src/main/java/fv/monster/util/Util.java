package fv.monster.util;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 *
 * @author Johan Saragih
 */
public class Util {

    public static String[] decodeCredential(String encodedCredential) {
        String credentials = new String(Base64.getDecoder().decode(encodedCredential), Charset.forName("UTF-8"));
        // credentials = username:password
        return credentials.split(":", 2);
    }
}
