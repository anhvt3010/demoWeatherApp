package com.anhvt.weather_app.controllers;

import com.anhvt.weather_app.Navigator;
import com.anhvt.weather_app.services.SignUpService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpController {
    @FXML
    private Button btn_SignUp_Register;

    @FXML
    private TextField txt_SignUp_Confirmpassword;

    @FXML
    private TextField txt_SignUp_email;

    @FXML
    private TextField txt_SignUp_password;

    @FXML
    void RegisterAccount(ActionEvent event) throws IOException {
        String email = txt_SignUp_email.getText().trim();
        String password = txt_SignUp_password.getText();
        String confirm_password = txt_SignUp_Confirmpassword.getText();
        if(SignUpService.signUp(email,password,confirm_password))
            Navigator.getInstance().gotoLogin();

    }
}
