package com.xzf.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller implements Serializable {

    private Integer sellerid;

    private String sname;

    private String saddress;

    private String businesslicense;

    private String sphone;

    private String spasswoed;

    private Integer sstatus;

    private String ssex;

    private String semail;




}
