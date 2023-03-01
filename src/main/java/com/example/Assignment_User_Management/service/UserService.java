package com.example.Assignment_User_Management.service;

import com.example.Assignment_User_Management.dao.UserRepo;
import com.example.Assignment_User_Management.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void addUser(UserModel model) {
        userRepo.save(model);
    }

    public String getAnUser(Integer userId) {

        if(userRepo.findById(userId).isPresent()) {
            UserModel model = userRepo.findById(userId).get();
            return model.toString();
        }
        return "false";

    }

    public List<UserModel> getUser() {
        return userRepo.findAll();
    }

    public String updateUser(Integer userId, UserModel model) {
        if(userRepo.findById(userId).isPresent()) {
            UserModel model1=new UserModel();
            model1.setDate(model.getDate());
            model1.setTime(model.getTime());
            model1.setEmail(model.getEmail());
            model1.setUsername(model.getUsername());
            model1.setDateOfBirth(model.getDateOfBirth());
            model1.setPhoneNumber(model.getPhoneNumber());
            UserModel save = userRepo.save(model);
            return save.toString();
        }
        return "false";
    }

    public String  deleteUser(Integer userId) {
        if(userRepo.findById(userId).isPresent()) {
            userRepo.deleteById(userId);
            return "done";
        }
        return "fail";
    }
}
