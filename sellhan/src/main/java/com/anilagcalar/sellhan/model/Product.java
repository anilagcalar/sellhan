package com.anilagcalar.sellhan.model;

public class Product {

	private Long id;
	private String name;
	private String model;
	private double price;
	private String color;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", model=" + model + ", price=" + price + ", color=" + color
				+ "]";
	}
	
}
