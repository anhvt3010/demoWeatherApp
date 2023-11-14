package com.anhvt.weather_app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {
    private static Navigator navigator;
    private Stage stage;

    private Navigator() {
    }

    public static Navigator getInstance() {
        if (navigator == null) {
            navigator = new Navigator();
        }
        return navigator;
    }

    public void setStage(Stage stage) {
        navigator.stage = stage;
    }

    // ------- URL---------------
    public static final String LOGIN = "sign-in.fxml";
    public static final String REGISTER = "sign-up.fxml";


    public void gotoScene(String title, String URL) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(URL));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(title);
        stage.setScene(scene);
        if(!stage.isShowing()){
            stage.show();
        }
    }

    public void gotoLogin() throws IOException {
        gotoScene("Login", LOGIN);
    }

    public void gotoRegister() throws IOException {
        gotoScene("Register", REGISTER);
    }
}
