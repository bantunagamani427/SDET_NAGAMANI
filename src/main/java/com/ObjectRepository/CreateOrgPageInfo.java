package com.ObjectRepository;
//Rule:1 create classname same as page name

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CreateOrgPageInfo {
//Rule:3 create constructor to initialize the driver
public CreateOrgPageInfo(WebDriver driver) {
PageFactory.initElements(driver,this);	
}
//Rule:2 locate all the elements with @findBy annotations
@FindBy(name="accountname")	
private WebElement orgnametextbox;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement savebutton;
//Rule 4:provide getters to access the private members
public WebElement getOrgnametextbox() {
	return orgnametextbox;
}
public WebElement getSavebutton() {
	return savebutton;
}

}
