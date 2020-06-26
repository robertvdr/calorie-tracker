package com.robvdr.model;

public class Log {

	// data types
	private int logId;
	private String date;
	private int foodId;
	private String quantity;
	private double calories;
	private double protein;
	private double carbs;
	private double fat;
	private String name;
	
	// getters and setters
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getCarbs() {
		return carbs;
	}
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
