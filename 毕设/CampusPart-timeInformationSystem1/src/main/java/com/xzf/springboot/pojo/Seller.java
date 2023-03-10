package com.xzf.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    private Integer sellerid;

    private String sname;

    private Integer sage;

    private String saddress;

    private String businesslicense;

    private String scardid;

    private String sphone;

    private String spasswoed;
}
