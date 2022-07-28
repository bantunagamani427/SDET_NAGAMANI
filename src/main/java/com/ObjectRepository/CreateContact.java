package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContact {
WebDriver driver;
public CreateContact(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactlink;
	public WebElement getcontactlink() {
		return contactlink;
		}
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContact;
	public WebElement getcreateContact() {
		return createContact;
		}
	
	@FindBy(name="salutationtype")
	private WebElement beforeFname;
	public WebElement getbeforeFname() {
		return beforeFname;
		}
	
	@FindBy(name="firstname")
	private WebElement firstname;
	public WebElement getfirstname() {
		return firstname;
		}
	
	@FindBy(name="lastname")
	private WebElement lastname;
	public WebElement getlastname() {
		return lastname;
		}
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement savebtn;
	public WebElement getsavebtn() {
		return savebtn;
		}
	
	}
