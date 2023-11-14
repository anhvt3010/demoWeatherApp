package com.anhvt.weather_app.services;

import com.anhvt.weather_app.daos.UserDAO;
import com.anhvt.weather_app.entities.User;
import com.anhvt.weather_app.utils.AlertUtil;
import com.anhvt.weather_app.utils.PasswordEncoder;
import com.anhvt.weather_app.utils.Session;

public class SignInService {
    public static Boolean checkLogin(String email, String password){
        if(email.isEmpty() || password.isEmpty()){
            AlertUtil.showErrorAlert("Login failed","Email and password cannot be blank","");
        } else {
            User user = UserDAO.getInstance().getUserByEmail(email);
            if(user != null){
                if(PasswordEncoder.verifyPassword(password,user.getPassword())){
                    Session.setAttribute(user);
                    return true;
                } else {
                    AlertUtil.showErrorAlert("Login failed","Email or password is wrong","");
                }
            } else {
                AlertUtil.showErrorAlert("Login failed","Email or password is wrong","");
            }
        }
        return false;
    }
}
