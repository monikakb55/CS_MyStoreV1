package com.MyStoreTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyStorePageObject.AccountCreationDetails;
import com.MyStorePageObject.IndexPage;
import com.MyStorePageObject.MyAccount;
import com.MyStorePageObject.RegisteredUserAccount;

public class TC_MyAccounPageTest extends BaseClass {

//Since this is a test method, so we have to declare it  with using TestNG annotation 	

	@Test(enabled=false)// enabled use if we don't want to execute the test case  .. 
	public void verifyRegistrationAndLogin() {

// Now we have to go on Index page and have to click on SignIn for that will create page object of index page (1st page)
		IndexPage indxPg = new IndexPage(driver); // Need to pass the object of WebDriver which is created in index page
													// constructor ..
//calling the method ofsingnIn  ..
		indxPg.clickOnSignIn();

//After clicking on SignIn, Account page will navigate wher have to enter email and click on 'create and account' button 
//So create the object of MyAccount page to perform the action  ..(2nd page)
	MyAccount myAcPg = new MyAccount(driver);
	myAcPg.enterEmailAddress("monikaVaishkiyar99@gmail.com");
	myAcPg.clickSubmitCreate();

//	3rd Page  ..
	AccountCreationDetails accountCrtnDtlPg = new AccountCreationDetails(driver);
	accountCrtnDtlPg.enterCustomerFirstName("Sindhu");
	logger.info("First name enter");
	accountCrtnDtlPg.enterCustoomerLastName("Kumari");
	logger.info("Last name enter");
//	accountCrtnDtlPg.enterEmailAddrs("monikaVaishkiyar99@gmail.com");
	accountCrtnDtlPg.enterPassword("Continen@99");
	accountCrtnDtlPg.clickOnRegisterBtn();
	logger.info("Click on Register button");

	//4th page- RegisteredUserAccount ..
	RegisteredUserAccount regstUserAcPg = new RegisteredUserAccount(driver);
	String userName = regstUserAcPg.getUserName();
// For verification of the user will use  assert class,  in testng assert is use for verification 	
	Assert.assertEquals("Sindhu Kumari", userName); //1st is expected user name and 2nd is actual user name  ..
		
	}
	
	@Test
	public void VerifyLogin() throws IOException {
		
		IndexPage indxPg = new IndexPage(driver);
		indxPg.clickOnSignIn();
		
		MyAccount myAcPg = new MyAccount(driver);  
		myAcPg.enterEmailAddress("sindhu.k3@rediffmail.com");
		logger.info("Entered email address");
		myAcPg.enterPassword("Continen@99");
		logger.info("Entered password");
		myAcPg.clickSignIn();;
		
		RegisteredUserAccount regstUserAcPg = new RegisteredUserAccount(driver);
		String userName = regstUserAcPg.getUserName();
		
		if(userName.equals("Sindhu Kumari"))
		{
			logger.info("verifyLogin- passed");
			Assert.assertTrue(true);
		} 
		else		
		{
			logger.info("VerifYLogin - failed ");
			captureScreenshot(driver, "VerifyLogin");
			Assert.assertTrue(false);
		}
	
		regstUserAcPg.clickOnSignOut();
		logger.info("Clicked on SignOut");
		
	}
	
	
	
	
	
	
	
	
	
	

}
