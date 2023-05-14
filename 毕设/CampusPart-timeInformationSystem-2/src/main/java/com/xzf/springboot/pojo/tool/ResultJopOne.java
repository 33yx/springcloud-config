package com.xzf.springboot.pojo.tool;

import com.xzf.springboot.pojo.Jop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultJopOne {
    private Integer id;
    private Jop jop;
    private String msg;
}
