package com.xzf.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String usename;
    private Integer useage;
    private String schoollname;
    private String studentid;
    private String cardid;
    private String phone;
    private String password;
    private Integer status;
}
