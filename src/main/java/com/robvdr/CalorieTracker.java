package com.robvdr;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.robvdr.model.Food;
import com.robvdr.model.FoodDAO;
import com.robvdr.model.jdbc.JDBCFoodDAO;

public class CalorieTracker {

	private FoodDAO foodDAO;
	
	public static void main(String[] args) {
		CalorieTracker calorieTracker = new CalorieTracker();
		calorieTracker.run();
	}
	public CalorieTracker(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/calories");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		foodDAO = new JDBCFoodDAO(dataSource);
	}
	
	private void run() {
		System.out.println("                                     ALL FOODS");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("%-20s %-17s %-12s %-12s %-12s %-12s \n", "NAME", "SERVING SIZE", "CALORIES(g)", "PROTEIN(g)", "CARBS(g)", "FAT(g)");
		List<Food> allFoods = foodDAO.getAllFoods();
		listFoods(allFoods);
	}
	

	
	private void listFoods(List<Food> foods) {
		if(foods.size() > 0) {
			for (Food item : foods) {
				System.out.printf("%-20s %-17s %-12s %-12s %-12s %-12s \n", item.getName(), item.getQuantity(), item.getCalories(), item.getProtein(), item.getCarbs(), item.getFat());
			}
		} else {
			System.out.println("\n*** No results ***");
		}
	}

}
