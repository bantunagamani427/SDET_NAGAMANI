package com.Vtiger.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author :nagamani
 * @ description: this class is going to create all the classes to reduce the code
 */
public class WebDriverUtil {
	WebDriver driver;
	/**
	 * @author :nagamani
	 * @description :this constructor is going to initilize the non static property of webdriver
	 */
	public WebDriverUtil(WebDriver driver) {
		this.driver=driver;	
	}
	/**
	 * @author :nagamani
	 * @description :this method is going to maximize the window
	 */
	public void maximizeWindow() 
	{
		driver.manage().window().maximize();	
	}
	/**
	 * @author :nagamani
	 * @description:this method is going to load the page
	 */
	public void pageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
	}
	/**
	 * @author :nagamani
	 * @description :this method is  going to  wait and Click the element if implicit wait is not working
	 */
	public void waitanClick(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	/**
	 * @author :Nagamani
	 * @description :this method is going to select the dropdown by index mathod
	 */
	public void select_DD(WebElement element,int index) {
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	/**
	 *@author :nagamani 
	 * @description :this method is going to select dropdown  by selecting string
	 */
	public void select_DD(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * @author nagamani
	 * @description :this method is going to select the dropdown by selecting the visible text 
	 */
	public void select_DD(String visibletext,WebElement element) {
		Select s=new Select(element);
		s.selectByValue(visibletext);
	}
	/**
	 * @author nagamani
	 * @description :this method is going to create move the element to the particular element
	 */
	public void moveToElement(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	/**
	 * @author nagamani
	 * description : This method is going to close the browser
	 */
	public void browser() {
		driver.close();
	} 
	/**
	 * @author nagamani
	 * description: this mthod is going to ceate to accept the alert popup
	 */
	public void refreshPge() {
		driver.navigate().refresh();
	}
	/**
	 * @author nagamani
	 * description : this method is going to create accept the alert
	 */
	public void acceptAlert() {
		driver.switchTo().alert().accept();
 }}
