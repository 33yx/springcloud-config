package com.xzf.springboot.pojo.tool;

import com.xzf.springboot.pojo.SellerAndCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultSeller {
    private Integer id;
    private SellerAndCard sellerAndCard;
}
