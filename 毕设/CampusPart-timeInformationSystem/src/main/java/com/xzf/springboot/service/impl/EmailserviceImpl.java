package com.xzf.springboot.service.impl;

import com.xzf.springboot.service.Emailservice;
import com.xzf.springboot.tool.EmailUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailserviceImpl implements Emailservice {


    @Async
    public void sendemail(String phone, String code) {

        EmailUtil.sendAuthCodeEmail(phone,code);

    }
}
