package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyPage {
	WebDriver driver;
	public VerifyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement deleteVerify;
	public WebElement getdeleteVerify() {
		return deleteVerify;
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyCreated;
	public WebElement getverifyCreated() {
		return verifyCreated;
		
	}

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchtextbox;
	public WebElement getsearchtextbox() {
		return searchtextbox;
	}

	@FindBy(xpath="//select[@id='bas_searchfield']")
	private WebElement dropdown;
	public WebElement getdropdown() {
		return dropdown;
	}
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchNow;
	public WebElement getsearchNow() {
		return searchNow;
		}
	




}
