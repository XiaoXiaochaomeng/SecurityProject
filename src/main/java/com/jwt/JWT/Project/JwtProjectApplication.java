package com.jwt.JWT.Project;

import com.jwt.JWT.Project.config.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication
public class JwtProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtProjectApplication.class, args);
	}

}
