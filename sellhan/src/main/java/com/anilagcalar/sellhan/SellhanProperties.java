package com.anilagcalar.sellhan;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="sellhan")
public class SellhanProperties {

	private boolean displayOwnersWithProducts = false;

	public boolean isDisplayOwnersWithProducts() {
		return displayOwnersWithProducts;
	}

	public void setDisplayOwnersWithProducts(boolean displayOwnersWithProducts) {
		this.displayOwnersWithProducts = displayOwnersWithProducts;
	}
	
}
