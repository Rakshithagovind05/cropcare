package com.CropProject.CROPCARE.repository;

import com.CropProject.CROPCARE.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);
}
