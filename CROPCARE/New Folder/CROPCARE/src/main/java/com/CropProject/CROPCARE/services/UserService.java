package com.CropProject.CROPCARE.services;

import com.CropProject.CROPCARE.entity.UserEntity;
import com.CropProject.CROPCARE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ Save user
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

    // ✅ Check if username already exists
    public boolean isUserExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    // ✅ Authenticate user
    public UserEntity authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
