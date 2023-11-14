package com.anhvt.weather_app.services;

import com.anhvt.weather_app.dtos.UserDTO;
import com.anhvt.weather_app.entities.User;

public interface IUserService {
    User create(UserDTO userDTO);
    String findUserByEmail(String email);

}
