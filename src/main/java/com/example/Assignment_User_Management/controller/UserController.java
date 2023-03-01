package com.example.Assignment_User_Management.controller;

import com.example.Assignment_User_Management.model.UserModel;
import com.example.Assignment_User_Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserModel model){
        userService.addUser(model);
        return new ResponseEntity<>("User Added", HttpStatus.CREATED);
    }
    @GetMapping("/get-user/userId/{userId}")
    public ResponseEntity<String> getAnUser(@PathVariable Integer userId){
        String anUser = userService.getAnUser(userId);
        if(!anUser.equals("false")){
            return new ResponseEntity<>(anUser,HttpStatus.CREATED);
        }
        return new ResponseEntity<>("UserId not user by your input",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get-users")
    public List<UserModel> getUser(){
        return userService.getUser();
    }
    @PutMapping("/update-user/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Integer userId,@Valid @RequestBody UserModel model){
        userService.updateUser(userId,model);
        return new ResponseEntity<>("Updated successfully",HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-user")
    public ResponseEntity<String> deleteUser(@RequestParam Integer userId){
        String s = userService.deleteUser(userId);
        if(s.equals("done")) {
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Operation Failed userId doesn't exist", HttpStatus.BAD_REQUEST);
    }
}