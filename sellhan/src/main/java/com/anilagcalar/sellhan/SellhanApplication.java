package com.anilagcalar.sellhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@EnableConfigurationProperties(value=SellhanProperties.class)
public class SellhanApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(SellhanApplication.class, args);
		
	}

}
