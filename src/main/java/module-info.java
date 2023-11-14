module com.anhvt.weather_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;
    requires spring.data.jpa;
    requires spring.context;
    requires spring.beans;
    requires jakarta.persistence;


    opens com.anhvt.weather_app to javafx.fxml;
    exports com.anhvt.weather_app;
    opens com.anhvt.weather_app.controllers to javafx.fxml;
}