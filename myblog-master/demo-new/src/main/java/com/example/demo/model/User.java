package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;


    private String phone;

    private String username;

    private String password;
    /**
     * 性别
     */
    private String gender;
    /**
     * 真实姓名
     */
    private String trueName;

    /**
     * 生日
     */
    private String birthday;

    public User(String phone, String username, String password, String gender) {
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }


}
