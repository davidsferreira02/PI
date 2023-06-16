package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void Register(String name, String username, String email, int age, String password, String gender, int role) {
        Users user = new Users();
        user.setAge(age);
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(password);
        user.setPassword(encryptedPassword);
        user.setUsername(username);
        user.setGender(gender);
        userRepository.save(user);
    }

    public int Login(String username, String password) {
        Users user = userRepository.findByUsername(username);

        if (user != null) {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(password, user.getPassword())) {
                return 1;
            }
            return 0;

        }
        return -1;
    }
}
