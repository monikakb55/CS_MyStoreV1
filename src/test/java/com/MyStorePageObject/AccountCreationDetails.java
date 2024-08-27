package com.MyStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationDetails {

	WebDriver driver;

	public AccountCreationDetails(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_gender2")
	WebElement titleMrs;

	@FindBy(css = "[id*='customer_firstname']")
	WebElement cstmrFirstNm;

	@FindBy(css = "[id*='customer_lastname']")
	WebElement cstmrLastNm;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailAddrs;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement pswd;

	@FindBy(id = "submitAccount")
	WebElement register;

	public void selectTitle() {
		titleMrs.click();
	}

	public void enterCustomerFirstName(String fName) {
		cstmrFirstNm.sendKeys(fName);
	}

	public void enterCustoomerLastName(String lName) {

		cstmrLastNm.sendKeys(lName);
	}

//	public void enterEmailAddrs(String emailAddress) {
//		
//		emailAddrs.clear();
//		
//		emailAddrs.sendKeys("emailAddress");
//	}

	public void enterPassword(String password) {

		pswd.sendKeys("password");

	}

	public void clickOnRegisterBtn() {

		register.click();
	}

}
