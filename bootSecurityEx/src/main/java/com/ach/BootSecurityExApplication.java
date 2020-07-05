package com.ach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // 추가
public class BootSecurityExApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSecurityExApplication.class, args);
	}

}
