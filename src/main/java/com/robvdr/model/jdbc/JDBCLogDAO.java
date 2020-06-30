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
	public Log addEntry(Log newLog) {
		String sql = "INSERT INTO log (log_date, food_id) VALUES (?, ?) RETURNING log_id;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, newLog.getDate(), newLog.getFoodId());
		if(results.next()) {
			newLog.setLogId(results.getInt("log_id"));
		}
		return newLog;
	}

	@Override
	public void deleteLogEntry(int logId) {
		String sqlDeleteLog = "DELETE FROM log WHERE log_id = ?;";
		jdbcTemplate.update(sqlDeleteLog, logId);
		System.out.print("Deleted");;
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

	public List<Log> getAllLogsForDelete() {
		List<Log> allLogsForDelete = new ArrayList<>();
		String sqlAllLogsForDelete = "SELECT l.log_id, l.log_date, f.food_name, f.food_quantity FROM log l JOIN foods f ON l.food_id = f.food_id ORDER BY l.log_date DESC;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllLogsForDelete);
		while (results.next()) {
			Log logResult = new Log();
				logResult.setLogId(results.getInt("log_id"));
				logResult.setDate(results.getString("log_date"));
				logResult.setName(results.getString("food_name"));
				logResult.setQuantity(results.getString("food_quantity"));
				allLogsForDelete.add(logResult);
		}
		return allLogsForDelete;
	}

}
