package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1:create class name as page name
public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//rule 2 : locate elements using @find by and make webelement as private
	
	
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orglinkbtn;
    public WebElement getOrglinkbtn() {
		return orglinkbtn;
	}

    @FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homepageimg;
	public WebElement getHomepageimg() {
		return homepageimg;
	}
    
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	public WebElement getSignoutimg() {
		return signoutimg;
	}


	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutlink;
	public WebElement getsignoutlink() {
		return signoutlink;
	}
}
