package com.anhvt.weather_app;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Navigator.getInstance().setStage(stage);
        Navigator.getInstance().gotoLogin();
    }

    public static void main(String[] args) {
        launch();
    }
}