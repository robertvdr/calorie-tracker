package com.robvdr.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.robvdr.model.Food;
import com.robvdr.model.FoodDAO;

public class JDBCFoodDAO implements FoodDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCFoodDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Food> getAllFoods() {
		List<Food> allFoods = new ArrayList<>();
		String sqlAllFoods = "SELECT food_name, food_quantity, food_calories, food_protein, food_carbs, food_fat FROM foods ORDER BY food_name";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllFoods);
		while (results.next()) {
			Food foodResult = mapRowToFood(results);
			allFoods.add(foodResult);
		}
		return allFoods;
	}

	@Override
	public Food getSampleByID(long id) {
		// TODO 
		return null;
	}

	@Override
	public Food getSampleByName(String name) {
		// TODO 
		return null;
	}

	@Override
	public Food createSample(long id, String name) {
		// TODO 
		return null;
	}

	@Override
	public Food updateSample(long id, String name) {
		// TODO 
		return null;
	}

	@Override
	public void removeSampleByID(long id) {
		// TODO 
	}
	
	private Food mapRowToFood(SqlRowSet results) {
		Food food = new Food();
		food.setName(results.getString("food_name"));
		food.setQuantity(results.getString("food_quantity"));
		food.setCalories(results.getDouble("food_calories"));
		food.setProtein(results.getDouble("food_protein"));
		food.setCarbs(results.getDouble("food_carbs"));
		food.setFat(results.getDouble("food_fat"));
		return food;
	}

}
