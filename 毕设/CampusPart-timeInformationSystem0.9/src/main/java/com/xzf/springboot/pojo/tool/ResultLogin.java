package com.xzf.springboot.pojo.tool;

import com.xzf.springboot.pojo.Seller;
import com.xzf.springboot.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultLogin {
    private Integer id;
    private Integer idery;
    private User user;
    private Seller seller;
    private String msg;
}
