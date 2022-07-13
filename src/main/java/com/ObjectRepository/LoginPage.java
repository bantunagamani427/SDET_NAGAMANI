package com.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Rule 1: Class name should be the pagename
public class LoginPage {
WebDriver driver;	
//Rule 3:Create the constructor to initilise the page elements	
public LoginPage() {
PageFactory.initElements(driver,this);	
}	
//Rule 2:loacte all the elements with @findby annotation and make that elements as private
@FindBy(name="user_name")
private WebElement usernametxtbox;
@FindBy(name="user_password")
private WebElement passwordtxtbox;
@FindBy(id="submitButton")
private WebElement loginbutton;
//Rule 4:create getters to access the private webelements
public WebElement getUsernametextbox() {
	return usernametxtbox;
}
public WebElement getPaaswordtxtbox() {
	return passwordtxtbox;
}
public WebElement getLoginbutton() {
return loginbutton;	
}
}
