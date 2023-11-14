package com.anhvt.weather_app.daos;

import com.anhvt.weather_app.entities.User;
import com.anhvt.weather_app.utils.JDBCUtil;
import com.anhvt.weather_app.utils.PasswordEncoder;

import java.sql.*;
import java.time.LocalDate;

public class UserDAO implements IDAO<User>{
    static Connection cnn = null;
    PreparedStatement stm = null;

    public static UserDAO getInstance(){
        cnn = JDBCUtil.getConnection();
        return new UserDAO();
    }


    @Override
    public String create(User user) {
        String sql = "INSERT INTO users(email, password) VALUES (?, ?)";
        try {
            stm = cnn.prepareStatement(sql);
            stm.setString(1, user.getEmail());
            stm.setString(2, PasswordEncoder.encodePassword(user.getPassword()));
            stm.executeUpdate();
            return "Create successfully!";
        } catch (Exception e){
            return "Create failed!";
        } finally {
            JDBCUtil.closePreparedStatement(stm);
            JDBCUtil.closeConnection(cnn);
        }
    }

    public User getUserByEmail(String email) {
        User user = null;
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement stm = cnn.prepareStatement(sql)) {
            stm.setString(1, email);
            try (ResultSet resultSet = stm.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.closeConnection(cnn);
        }
        return user;
    }



}
