package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;

    private String phone;

    private String username;

    private String password;

    private String gender;

    private String trueName;


    private String birthday;
}
