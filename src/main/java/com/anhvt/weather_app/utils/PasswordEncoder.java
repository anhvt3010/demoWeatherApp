package com.anhvt.weather_app.utils;
import org.mindrot.jbcrypt.BCrypt;
public class PasswordEncoder {
    public static String encodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
