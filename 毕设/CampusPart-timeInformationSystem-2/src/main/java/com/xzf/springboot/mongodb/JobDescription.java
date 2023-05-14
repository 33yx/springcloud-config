package com.xzf.springboot.mongodb;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("JopDescriprions")//集合名
public class JobDescription {

    @Id//跟mongodb中的_id
    Integer id;

    @Field(value = "content")//指定在数据库中的名称
    String description;



}
