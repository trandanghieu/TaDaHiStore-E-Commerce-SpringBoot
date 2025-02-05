package com.tadahi.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.tadahi.common.entity", "com.tadahi.admin.user"})
public class TaDaHiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaDaHiBackendApplication.class, args);
	}

}
