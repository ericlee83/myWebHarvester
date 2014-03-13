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
		/*driver.findElement(By.id("myrea-sign-in")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailInp")));
		driver.findElement(By.id("emailInp")).sendKeys(myResources.getString(RealEstateValue.USER_EMAIL));
		driver.findElement(By.id("pass")).sendKeys(myResources.getString(RealEstateValue.USER_PASS));
		driver.findElement(By.cssSelector("button.rui-button-brand")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("goback")));
		driver.findElement(By.id("goback")).click();*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("where")));
		driver.findElement(By.id("includeSurrounding")).click();
		driver.findElement(By.id("where")).clear();
		driver.findElement(By.id("where")).sendKeys("Burwood, NSW 2134");
		driver.findElement(By.id("searchBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("propertyType")));
		driver.findElement(By.id("propertyType")).click();
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[type='checkbox']")));
		List<WebElement> eList = driver.findElements(By.xpath("//input[type='checkbox'"));
		for(WebElement e : eList){
			if("unit apartment"==e.getAttribute("value")){
				e.click();
				break;
			}
		}*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='LMIDD_propertyType']/div[2]/dl/dd[3]/label")));
		driver.findElement(By.xpath("////div[@id='LMIDD_propertyType']/div[2]/dl/dd[3]/label")).click();
		driver.findElement(By.cssSelector("button.button.plusplus")).click();

	}
	
	public void close() {
		driver.close();
	}

}
