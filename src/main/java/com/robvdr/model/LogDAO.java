package com.robvdr.model;

import java.util.List;

public interface LogDAO {

	public Log addEntry(Log newEntry);
	public void deleteEntry(int logId);
	public List<Log> getDailyLog(String logDate);
	public List<Log> getAllLogs();
}
