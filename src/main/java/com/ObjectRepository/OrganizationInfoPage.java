package com.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Rule 1:class name should  be the pagename
public class OrganizationInfoPage {
	//Rule 3:create constructor to intilize the driver
public OrganizationInfoPage(WebDriver driver) {
PageFactory.initElements(driver, this);	
}
	//Rule 2:locate all the elements and make them as private
@FindBy(xpath="//a[text()='Organizations']")	
private WebElement orglink;
@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement createorgplus;
@FindBy(name="search_text")
private WebElement searchorgtxtbox;
@FindBy(name="search_field")
private WebElement selectorgtypeDD;
@FindBy(name="submit")
private WebElement searchnowbutton;
@FindBy(xpath="//a[@title='Organizations']")
private WebElement searchorgname;
//Rule 4:provide getters for accessing private members 
public WebElement getOrglink() {
	return orglink;
}
public WebElement getCreateorgplus() {
	return createorgplus;
}
public WebElement getSearchorgtxtbox() {
	return searchorgtxtbox;
}
public WebElement getSelectorgtypeDD() {
	return selectorgtypeDD;
}
public WebElement getSearchnowbutton() {
	return searchnowbutton;
}
public WebElement getSearchorgname() {
	return searchorgname;
}

}