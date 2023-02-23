package com.xzf.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerAndCard {
    private Integer sellerid;

    private String sname;

    private String saddress;

    private String businesslicense;

    private String sphone;

    private String spasswoed;

    private Integer sstatus;

    private String ssex;

    private String semail;

    private String carid;

    private String cname;

    private String cage;


}
