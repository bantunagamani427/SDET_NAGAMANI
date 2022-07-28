package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2
{

	WebDriver driver;

	public LoginPage2(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(name="user_name")
	private WebElement username;

	@FindBy(name="user_password")
	private WebElement password;

	@FindBy(id="submitButton")
	private WebElement loginbtn;


	
	
	public WebElement getUsername() {
		return username;
	}




	public WebElement getPassword() {
		return password;
	}




	public WebElement getLoginbtn() {
		return loginbtn;
	}




	public void logintoApp(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();

	}



}
