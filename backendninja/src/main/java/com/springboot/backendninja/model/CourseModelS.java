package com.springboot.backendninja.model;

public class CourseModelS {

	private int id;
	private String name;
	private String description;
	private String price;
	private String hours;

	
	
	public CourseModelS() {
	}

	public CourseModelS(int id, String name, String description, String price, String hours) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "CourseModelS [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", hours=" + hours + "]";
	}

}
