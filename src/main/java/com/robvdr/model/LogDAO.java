package com.robvdr.model;

import java.util.List;

public interface LogDAO {

	public Log addEntry(Log newLog);
	public List<Log> getAllLogsForDelete();
	public void deleteLogEntry(int logId);
	public List<Log> getDailyLog(String logDate);
	public List<Log> getAllLogs();
}
