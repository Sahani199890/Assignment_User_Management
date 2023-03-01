package com.example.Assignment_User_Management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserModel {
    @Id
    @NotNull(message = "please enter id")
    private Integer userId;
    @NotBlank(message = "user name cannot be empty")
    private String username;
    @NotBlank(message = "BOD cannot be blank")
    private String dateOfBirth;
    @Email(message = "please enter valid mail")
    private String email;
    @Length(min = 10,max = 13,message = "number cannot be less than 10 digits")
    private  String phoneNumber;
    @NotBlank(message = "please provide valid date")
    private  String date;
    @NotBlank(message = "please provide valid time")
    private String time;
}
