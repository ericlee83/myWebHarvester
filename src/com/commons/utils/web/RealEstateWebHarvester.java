package com.commons.utils.web;

import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class RealEstateWebHarvester {
	
private static final String BASE_URL = "http://www.realestate.com.au/";
	
	private static final String SELENIUM_HOST = "localhost";
	private static final int SELENIUM_PORT = 4444;
	private static final String SELENIUM_BROWSER = "*firefox";
	
	private static final String SEARCH_URL = BASE_URL+"buy";
	
	private Selenium selenium = new DefaultSelenium(SELENIUM_HOST, SELENIUM_PORT,SELENIUM_BROWSER, BASE_URL);

	private SeleniumServer seleniumServer;
	
	public RealEstateWebHarvester() {
		// TODO Auto-generated constructor stub
	}

}
