package com.robvdr.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.robvdr.model.Log;
import com.robvdr.model.LogDAO;

public class JDBCLogDAO implements LogDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCLogDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Log addEntry(Log newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntry(int logId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Log> getDailyLog(String logDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log> getAllLogs() {
		List<Log> allLogs = new ArrayList<>();
		String sqlAllLogs = "SELECT l.log_date, f.food_name, f.food_quantity, f.food_calories, f.food_protein, f.food_carbs, f.food_fat FROM log l JOIN foods f ON l.food_id = f.food_id ORDER BY l.log_date;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllLogs);
		while (results.next()) {
			Log logResult = new Log();
			logResult.setDate(results.getString("log_date"));
			logResult.setName(results.getString("food_name"));
			logResult.setQuantity(results.getString("food_quantity"));
			logResult.setCalories(results.getDouble("food_calories"));
			logResult.setProtein(results.getDouble("food_protein"));
			logResult.setCarbs(results.getDouble("food_carbs"));
			logResult.setFat(results.getDouble("food_fat"));
			allLogs.add(logResult);
		}
		return allLogs;
	}

}
