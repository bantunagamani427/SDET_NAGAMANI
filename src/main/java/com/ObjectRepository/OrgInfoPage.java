package com.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Rule 1:class name should  be the pagename
public class OrgInfoPage {
	//Rule 3:create constructor to intilize the driver
public OrgInfoPage(WebDriver driver) {
PageFactory.initElements(driver, this);	
}
//Rule 2:locate all the elements and make them as private
//Rule 4:provide getters for accessing private members 
@FindBy(xpath="//a[text()='Organizations']")	
private WebElement orglink;
public WebElement getOrglink() {
	return orglink;
}
@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement createorgplus;
public WebElement getCreateorgplus() {
	return createorgplus;
}
@FindBy(name="search_text")
private WebElement searchorgtxtbox;
public WebElement getSearchorgtxtbox() {
	return searchorgtxtbox;
}
@FindBy(name="search_field")
private WebElement selectorgtypeDD;
public WebElement getSelectorgtypeDD() {
	return selectorgtypeDD;
}
@FindBy(name="submit")
private WebElement searchorgbutton;
public WebElement getSearchnowbutton() {
	return searchorgbutton;
}
@FindBy(xpath="//a[@title='Organizations']")
private WebElement searchorgname;
public WebElement getSearchorgname() {
	return searchorgname;
}

}