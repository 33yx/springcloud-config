package com.xzf.springboot.pojo.tool;

import com.xzf.springboot.pojo.Jop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultJop {
    private Integer id;
    private List<Jop> jops;
}
