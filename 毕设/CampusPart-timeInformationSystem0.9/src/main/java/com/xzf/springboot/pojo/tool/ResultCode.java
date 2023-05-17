package com.xzf.springboot.pojo.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultCode {
    private Integer Rid;
    private String msg;
    private String code;
}

