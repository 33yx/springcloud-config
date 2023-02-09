package com.entity.view;

import com.baomidou.mybatisplus.annotation.TableName;
import com.entity.QiuzhizhexinxiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
 

/**
 * 求职者信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-05-13 10:02:23
 */
@TableName("qiuzhizhexinxi")
public class QiuzhizhexinxiView  extends QiuzhizhexinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QiuzhizhexinxiView(){
	}
 
 	public QiuzhizhexinxiView(QiuzhizhexinxiEntity qiuzhizhexinxiEntity){
 	try {
			BeanUtils.copyProperties(this, qiuzhizhexinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
