package com.robvdr.model;

import java.util.List;

public interface FoodDAO {

	public List<Food> getAllFoods();
	public List<Food> getAllFoodsForDelete();
	public Food addFood(Food newFood);
	public void deleteFood(int foodId);
	
}
