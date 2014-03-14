package com.commons.utils.web;

import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.value.RealEstateValue;

public class RealEstateWebHarvester {
	
	private static final String BASE_URL = "http://www.realestate.com.au/";
	
	private static final String SEARCH_URL = BASE_URL+"buy";
	
	
	private WebDriver driver = new FirefoxDriver();
	private WebDriverWait wait = new WebDriverWait(driver, 5);
	ResourceBundle myResources ;
	
	public RealEstateWebHarvester() {
		// TODO Auto-generated constructor stub
		myResources= ResourceBundle.getBundle(RealEstateValue.REALESTATE_PROPERTIES);
	}
	
	public void start() throws Exception{
		driver.get(SEARCH_URL);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("where")));
		driver.findElement(By.id("includeSurrounding")).click();
		driver.findElement(By.id("where")).clear();
		driver.findElement(By.id("where")).sendKeys("Burwood, NSW 2134");
		driver.findElement(By.id("searchBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("propertyType")));
		driver.findElement(By.id("propertyType")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ddCb_propertyType_2']")));
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='unit apartment']")).click();
		driver.findElement(By.cssSelector("button.button.plusplus")).click();
		List<WebElement> eList = driver.findElements(By.xpath("//div[starts-with(@id,'results_')]"));
		WebElement temp;
		for(WebElement e : eList){
			temp = e.findElement(By.cssSelector("a.name"));
			if(temp != null){
				System.out.println(temp.getText()+"------>"+temp.getAttribute("href"));
			}
		}

	}
	
	public void close() {
		//driver.close();
	}

}
