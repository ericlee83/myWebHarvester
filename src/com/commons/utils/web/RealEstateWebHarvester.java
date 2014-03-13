package com.commons.utils.web;

import java.util.ResourceBundle;

import org.openqa.selenium.server.SeleniumServer;

import com.commons.value.RealEstateValue;
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
	
	ResourceBundle myResources = ResourceBundle.getBundle(RealEstateValue.REALESTATE_PROPERTIES);
	
	public RealEstateWebHarvester() {
		// TODO Auto-generated constructor stub
	}
	
	public void start() throws Exception{
		selenium.start();
		selenium.open(SEARCH_URL);
		selenium.click("id=myrea-sign-in");
		selenium.waitForPageToLoad("5000");
		selenium.type("id=emailInp", myResources.getString(RealEstateValue.USER_EMAIL));
		selenium.type("id=pass", myResources.getString(RealEstateValue.USER_PASS));
		selenium.click("css=button.rui-button-brand");
		selenium.waitForPageToLoad("5000");
		selenium.click("id=goback");
		selenium.waitForPageToLoad("10000");
		selenium.type("id=where", "Burwood, NSW 2134");
		selenium.click("id=includeSurrounding");
		selenium.click("id=searchBtn");
		selenium.waitForPageToLoad("5000");
	}
	
	public void close() {
		if (null != seleniumServer) {
			seleniumServer.stop();
			seleniumServer = null;
		}
		selenium.stop();
	}

}
