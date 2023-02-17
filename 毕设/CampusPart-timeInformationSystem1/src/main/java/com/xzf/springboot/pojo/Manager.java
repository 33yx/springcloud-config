package com.xzf.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

    private Integer managerid;

    private String mphone;

    private String mpasswoed;
}
