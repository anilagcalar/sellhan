package com.anilagcalar.sellhan;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SellhanConfiguration {

@Autowired	
private SellhanProperties sellhanProperties;


@PostConstruct
public void init() {
	System.out.println("Display owners with products :" + sellhanProperties.isDisplayOwnersWithProducts());
	
	 
}
	
}
