package com.xzf.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager implements Serializable {

    private Integer managerid;

    private String mphone;

    private String mpassword;

    private String musername;

    private int power;

    private String mrole;
}
