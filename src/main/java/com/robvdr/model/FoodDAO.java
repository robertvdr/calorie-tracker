package com.robvdr.model;

import java.util.List;

public interface FoodDAO {

	public List<Food> getAllFoods();
	public Food getSampleByID(long id);
	public Food getSampleByName(String name);
	public Food createSample(long id, String name);
	public Food updateSample(long id, String name);
	public void removeSampleByID(long id);
	
}
