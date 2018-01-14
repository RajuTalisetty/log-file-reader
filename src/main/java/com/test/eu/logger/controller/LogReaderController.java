package com.test.eu.logger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.eu.logger.service.LoggerService;
/**
 * Front controller class to load the log file view page.
 * @author Raju Talisetty
 *
 */
@Controller
public class LogReaderController {
	/**
	 * Autowired the loggerservice class
	 */
	@Autowired
	private LoggerService loggerService;

	/**
	 * This method will read the log statistics and load the when the application invoked
	 * @param model Spring UI model to hold the model attributes
	 * @return the view name logger.
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/" })
	public String getLogInformation(Model model) {
		// read the stats from service class and save the content in model.
		model.addAttribute("logger", loggerService.returnLoggerModel());
		return "logger";
	}
}
