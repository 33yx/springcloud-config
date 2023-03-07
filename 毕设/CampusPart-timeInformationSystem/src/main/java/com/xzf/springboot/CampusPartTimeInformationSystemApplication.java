package com.xzf.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync//开启异步注解功能
@SpringBootApplication
public class CampusPartTimeInformationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampusPartTimeInformationSystemApplication.class, args);
	}

}
