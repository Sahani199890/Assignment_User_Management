package com.example.Assignment_User_Management.dao;

import com.example.Assignment_User_Management.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<UserModel,Integer> {
}
