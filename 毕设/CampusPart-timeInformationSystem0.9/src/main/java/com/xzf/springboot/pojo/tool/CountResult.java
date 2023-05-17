package com.xzf.springboot.pojo.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountResult {
    private int id;
    private Integer countUser; //学生数
    private Integer countSeller; //商家数
    private Integer countJop; //订单总数
    private Integer countJopw; //无效订单
    private Integer countJopok;//已审核订单
    private Integer countJopnot; //未审核订单

}
