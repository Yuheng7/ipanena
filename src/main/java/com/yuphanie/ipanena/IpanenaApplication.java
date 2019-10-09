package com.yuphanie.ipanena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "com.yuphanie.ipanena.repository")
@EntityScan
@SpringBootApplication
public class IpanenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpanenaApplication.class, args);
	}

}
