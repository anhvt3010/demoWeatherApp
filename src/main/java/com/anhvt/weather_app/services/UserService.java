package com.anhvt.weather_app.services;

import com.anhvt.weather_app.dtos.UserDTO;
import com.anhvt.weather_app.entities.User;
import com.anhvt.weather_app.repositories.UserRepository;
import com.anhvt.weather_app.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    public UserService(UserRepository userRepository) {
//       this.userRepository = userRepository;
//    }

    @Override
    public String findUserByEmail(String email){
        if(userRepository.findUserByEmail(email) == null){
            return "ko co";
        }
        return "co ton tai";
    }
    public Optional<User> findUserByID(Long id){
        return userRepository.findById(id);
    }

    @Override
    public User create(UserDTO userDTO) {
        String email = userRepository.findUserByEmail(userDTO.getEmail());
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(PasswordEncoder.encodePassword(userDTO.getPassword()));
        return userRepository.save(user);
    }
}
