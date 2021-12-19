package com.OEMarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@MapperScan(value = { "com.OEMarket.mapper" })
@EnableJpaRepositories(basePackages = "com.OEMarket.repository")
@SpringBootApplication
public class OeMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(OeMarketApplication.class, args);
	}

}
