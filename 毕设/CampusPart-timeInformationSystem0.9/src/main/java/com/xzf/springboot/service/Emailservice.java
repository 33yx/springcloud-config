package com.xzf.springboot.service;

import org.springframework.stereotype.Service;


public interface Emailservice {

    void sendemail(String phone,String code);


}
