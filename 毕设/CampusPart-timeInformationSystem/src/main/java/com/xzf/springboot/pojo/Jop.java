package com.xzf.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jop implements Serializable {

    private Integer jopid;

    private String joptype;

    private String sellerid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp pubdate;

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
//    private Timestamp stardate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp enddate;

    private String jobdescription;

    private Integer number;

    private String salary;

    private String address;

    private Integer examine;

    private String ouserid;

    private Integer valid;

    private  String errorreason;

}
