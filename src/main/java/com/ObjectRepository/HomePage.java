package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1:create class name as page name
public class HomePage {
	WebDriver driver;
//Rule 3:create the constructor to initiaze the webdriver	
public HomePage(WebDriver driver) {
PageFactory.initElements(driver, this);
}               
//Rule 2:locate all the elements by @findby annotation and make them as private
@FindBy(xpath="//a[text()='Organizations']")
private WebElement orglinkbutton;
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement signoutimg;
@FindBy(xpath="//a[text()='Sign Out']")
private WebElement signoutlink;
//Rule 4:provide gettersto access private members
public WebElement getOrglinkbutton(){
	return orglinkbutton;
	}
public WebElement getSignoutimg() {
	return signoutimg;
}
public WebElement getSignoutlink() {
	return signoutlink;
	}}
