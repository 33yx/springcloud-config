package com.xzf.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


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


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp datetime;
}
