package com.MyStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

//For pageObject class first we have to create WebDriver object ..
	WebDriver ldriver; // Local driver .

// we ll  create Constructor 
	public IndexPage(WebDriver rdriver) // It will take parameter of WebDriver object //remote driver
	{
//Now initialize l driver form rdriver  .
		ldriver = rdriver;
// rdriver- use for searching the WebElements and this- is object of page // now constructor is completed .		
		PageFactory.initElements(rdriver, this);
	}

// Now we ll identify the WebElements. In PageFactory we use @FindBy annotation for identifying the WebElement  .
	@FindBy(linkText = "Sign in")
	WebElement signIn; // created WebElement variable .
	
	@FindBy(xpath = "(//a[text()='T-shirts'])[2]")
	WebElement tshirt;

	// Identify action on webElement .
	
	public void clickOnTshirtMenu() {
		
		tshirt.click();
	}

	public void clickOnSignIn() {
		signIn.click();
	}

// ************ We identified the interacted webElements and its actions of IndexPage object **************

}
