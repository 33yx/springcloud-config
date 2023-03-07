package com.xzf.springboot.pojo.tool;

import com.xzf.springboot.pojo.JaU;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultJaU {
    private Integer id;
    private List<JaU> jaus;
    private String msg;
}
