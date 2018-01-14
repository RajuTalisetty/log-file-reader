package com.test.eu.logger.model;

public class LoggerModel {
	
	private int infoCount;
	private int warningCount;
	private int errorCount;
	private String logFileText;
	
	public int getInfoCount() {
		return infoCount;
	}
	public void setInfoCount(int infoCount) {
		this.infoCount = infoCount;
	}
	public int getWarningCount() {
		return warningCount;
	}
	public void setWarningCount(int warningCount) {
		this.warningCount = warningCount;
	}
	public int getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}
	public String getLogFileText() {
		return logFileText;
	}
	public void setLogFileText(String logFileText) {
		this.logFileText = logFileText;
	}

}
