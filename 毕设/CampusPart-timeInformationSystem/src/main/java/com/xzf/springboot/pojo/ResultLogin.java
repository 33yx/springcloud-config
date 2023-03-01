package com.xzf.springboot.pojo;

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
}
