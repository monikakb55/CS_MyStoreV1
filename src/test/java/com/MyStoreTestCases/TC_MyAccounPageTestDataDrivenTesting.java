package com.MyStoreTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MyStorePageObject.AccountCreationDetails;
import com.MyStorePageObject.IndexPage;
import com.MyStorePageObject.MyAccount;
import com.MyStorePageObject.RegisteredUserAccount;
import com.MyStoreUtilities.ReadExcelFile;

public class TC_MyAccounPageTestDataDrivenTesting extends BaseClass {

//Since this is a test method, so we have to declare it  with using TestNG annotation 	

	@Test(enabled=false)// enabled use if we don't want to execute the test case  .. 
	public void verifyRegistrationAndLogin() {

// Now we have to on Index page and have to click on SignIn for that will create page object of index page (1st page)
		IndexPage indxPg = new IndexPage(driver); // Need to pass the object of WebDriver which is created in index page
													// constructor ..
//calling the method ofsingnIn  ..
		indxPg.clickOnSignIn();

//After clicking on SignIn, Account page will navigate when have to enter email and click on 'create and account' button 
//So create the object of MyAccount page to perform the action  ..(2nd page)
	MyAccount myAcPg = new MyAccount(driver);
	myAcPg.enterCreateEmailAddress("monikaVaishkiyar99@gmail.com");
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
	
//Here dataProvider attribute used to provide the data of the test case  ..
    @Test(dataProvider = "LoginDataProvider")	
	public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException {
		
    	IndexPage indxPg = new IndexPage(driver);
		indxPg.clickOnSignIn();
		
		MyAccount myAcPg = new MyAccount(driver);  
		myAcPg.enterEmailAddress(userEmail);

		logger.info("Entered email address");
		myAcPg.enterPassword(userPwd);
		logger.info("Entered password");
		myAcPg.clickSignIn();
		logger.info("Click on sign in button");
		
		RegisteredUserAccount regstUserAcPg = new RegisteredUserAccount(driver);
		String userName = regstUserAcPg.getUserName();
		
		if(userName.equals(expectedUsername))
		{
			logger.info("verifyLogin- passed");
			Assert.assertTrue(true);
			
			regstUserAcPg.clickOnSignOut();
			logger.info("Clicked on SignOut");
		} 
		else		
		{
			logger.info("VerifYLogin - failed ");
			captureScreenshot(driver, "VerifyLogin");
			Assert.assertTrue(false);
		}
	
		
	}
		
	
// For providing the data of the test case we have to create a dataProvider method ..
// dataProvider always returns two dimensional objects  .. return type will be String  ..
	
	@DataProvider(name = "LoginDataProvider")
	public String [][]LoginDataProvider() // Method body- LoginDataProvider ..
   {
	String fileName =  System.getProperty("user.dir") + "//TestData//MyStoreTestDta2.xlsx";
	
	int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
	
	int ttlColumns = ReadExcelFile.getColCount(fileName,"LoginTestData");
	
	String  data[][] = new String[ttlRows-1][ttlColumns];  //Created two dimensional String object to pass the value of row and column...
	
	for(int i = 1; i<ttlRows; i++) {
		
		for(int j = 0; j<ttlColumns; j++) {

// This data storing in the 2 dimensional object which is - String  data[][] = new String[ttlRows -1][ttlColumns];	...then returned in , after 
// Returning the data it will go to VerifyLogin method ..
			data[i-1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
		}
	}
	
		
	return data;
	
	
  }
	
	
// * Which dataProvider name will use in @DataProvider(name ="LoginDataProvider") , the same name we have to provide in VerifyLogin ..
	
	
	
	
	
	
	

}
