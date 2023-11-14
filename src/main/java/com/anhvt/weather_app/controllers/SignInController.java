package com.anhvt.weather_app.controllers;

import com.anhvt.weather_app.Navigator;
import com.anhvt.weather_app.services.SignInService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignInController {
    @FXML
    private Hyperlink btn_Create;

    @FXML
    private Button btn_SignIn;

    @FXML
    private TextField txt_SignIn_Email;

    @FXML
    private TextField txt_SignIn_Password;


    @FXML
    void SignIn(ActionEvent event) {
        // handle username, password
        String email = txt_SignIn_Email.getText().trim();
        String password = txt_SignIn_Password.getText();

        if(SignInService.checkLogin(email,password)){
            System.out.print("Login successfully");
            // success => return main screen
        } else {
            // failed => return popup username and password error
            System.out.print("Login failed");
        }
    }
    @FXML
    void SignUp(ActionEvent event) throws IOException {
        Navigator.getInstance().gotoRegister();
    }
}
