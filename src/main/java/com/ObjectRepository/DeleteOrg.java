package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteOrg {
	WebDriver driver;
	public 	DeleteOrg(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orglinkbtn;
    public WebElement getOrglinkbtn() {
		return orglinkbtn;
	}
    
    @FindBy(name="search_text")
	private WebElement searchorgtxtbox;
	public WebElement getsearchorgtxtbox() {
		return searchorgtxtbox;

	}

	@FindBy(id="bas_searchfield")
	private WebElement selectorgtypeDD;
	public WebElement getSelectorgtypeDD() {
		return selectorgtypeDD;
	}


	@FindBy(name="submit")
	private WebElement searchorgbtn;
	public WebElement getSearchorgbtn() {
		return searchorgbtn;
	}


	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement searchedorgname;
	public WebElement getSearchedorgname() {
		return searchedorgname;
	}
	
	@FindBy(name="selected_id")
	private WebElement selectCheckBox;
	public WebElement getselectCheckBox() {
		return selectCheckBox;
		}
	
	@FindBy(name="selected_id")
	private WebElement selectCheckBox1;
	public WebElement getselectCheckBox1() {
		return selectCheckBox1;
		
	}
	
	
	
	
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deletebutton;
	public WebElement getdeletebutton() {
		return deletebutton;
		}
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement deleteVerify;
	public WebElement getdeleteVerify() {
		return deleteVerify;
		}

}
