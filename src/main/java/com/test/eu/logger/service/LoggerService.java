package com.test.eu.logger.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.test.eu.logger.controller.LogReaderController;
import com.test.eu.logger.model.LoggerModel;

/**
 * This Class will reads the log file in application start up and stores the results in LoggerModel.
 * @author Raju Talisetty
 *
 */
@Service
public class LoggerService {
	private static final Logger logger = LoggerFactory.getLogger(LoggerService.class);
	// REGEX Patterns to find the required text from logger
	private static final Pattern INFO_PATTERN = Pattern.compile("INFO[^*]");
	private static final Pattern WARNING_PATTERN =  Pattern.compile("WARNING[^*]");
	private static final Pattern ERROR_PATTERN = Pattern.compile("ERROR[^*]");
	
	private static int infoCount =0;
	private static int warnCount = 0;
	private static int errorCount = 0;
    private static StringBuilder contentBuilder = new StringBuilder();
    private static LoggerModel loggerModel = new LoggerModel();
	
	/**
	 * Reads the logfile when application startup.
	 */
		static {
			
			try {
				BufferedReader reader = new BufferedReader(new 
						InputStreamReader(LogReaderController.class.getClassLoader().getResourceAsStream("./logfile.log")));
				String sCurrentLine;
				while((sCurrentLine = reader.readLine()) != null) {
					 if(INFO_PATTERN.matcher(sCurrentLine).find())infoCount++;
				     if(ERROR_PATTERN.matcher(sCurrentLine).find()) errorCount++;
			         if(WARNING_PATTERN.matcher(sCurrentLine).find())warnCount++;
			         contentBuilder.append(sCurrentLine+"\n");
				}
				loggerModel.setErrorCount(errorCount);
				loggerModel.setInfoCount(infoCount);
				loggerModel.setWarningCount(warnCount);
				loggerModel.setLogFileText(contentBuilder.toString());
				logger.info("INFO Count:"+infoCount+" WARN Count:"+warnCount+" ERROR Count:"+errorCount);
				reader.close();
			} catch (IOException e) {
				logger.error("Problems Occured when reading the file."+e.getMessage());
			}
	}

	/**
	 * This method will returns the logger model
	 * @return LoggerModel
	 */
	public LoggerModel returnLoggerModel(){
		return loggerModel;
	}

}
