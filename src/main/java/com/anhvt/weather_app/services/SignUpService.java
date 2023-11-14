package com.anhvt.weather_app.services;

import com.anhvt.weather_app.daos.UserDAO;
import com.anhvt.weather_app.entities.User;
import com.anhvt.weather_app.utils.AlertUtil;
import com.anhvt.weather_app.utils.PasswordEncoder;
import com.anhvt.weather_app.utils.Session;
import com.anhvt.weather_app.validation.EmailValidator;

public class SignUpService {
    public static Boolean signUp(String email, String password, String confirm_password){
        if(email.isEmpty() || password.isEmpty() || confirm_password.isEmpty()){
            AlertUtil.showErrorAlert("Register failed","Field cannot be blank","");
            return false;
        }
        if(!password.equals(confirm_password)){
            AlertUtil.showErrorAlert("Register failed","Password does not match","");
            return false;
        }
        if(UserDAO.getInstance().getUserByEmail(email) != null ){
            AlertUtil.showErrorAlert("Register failed","Email already exists","");
            return false;
        }
//        if(EmailValidator.isValid(email)){
//            AlertUtil.showErrorAlert("Register failed","Invalid email","");
//            return false;
//        }
        AlertUtil.showInforEAlert("Register successfully","","");
        UserDAO.getInstance().create(new User(email, password));
        return true;
    }
}
