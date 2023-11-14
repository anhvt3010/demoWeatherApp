package com.anhvt.weather_app.repositories;
import com.anhvt.weather_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    String findUserByEmail(String email);
}
