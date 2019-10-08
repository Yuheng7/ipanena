package com.yuphanie.ipanena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EntityScan
@SpringBootApplication
public class IpanenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpanenaApplication.class, args);
	}

}
