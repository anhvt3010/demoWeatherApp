package com.anhvt.weather_app.utils;

import com.anhvt.weather_app.entities.User;

public class Session {
    private static User sessionData = new User() ;
    // Lưu dữ liệu vào phiên
    public static void setAttribute(User value) {
        sessionData = value ;
    }
    // Lấy dữ liệu từ phiên
    public static User getAttribute() {
        return sessionData;
    }
    public static void removeAttribute() {
        sessionData = new User();
    }

}
