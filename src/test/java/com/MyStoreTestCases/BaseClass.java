package com.MyStoreTestCases;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.MyStoreUtilities.ReadConfiig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

// All the reusable methods will add in the BaseCalass ...
	ReadConfiig readConfig = new ReadConfiig();

	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	String emailAddress = readConfig.getEmail();
	String password = readConfig.getPassword();
	
// Created variable for  WebDriver  ..
	public static WebDriver driver;
// Created variable for Logger ..
	public static Logger logger;

	@BeforeClass // First of all setup method need to execute
	public void setup() {

		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "msedge":
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		driver.manage().window().maximize();
// Implicit wait is applicable for all the webElements of all the classes,  if webElement does not find 10 sec wait will implements  .
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
// For log and read the runtime test data will need to create Logger class object and also have to create Log4J2 properties file in src/main/recource folder
// Created Log4j2 file in src/main/resources folder to implement the logging  ..
// Initialize the Logger object	..	
		logger = LogManager.getLogger("MyStoreV1");
		
		// Browser will launch form base class because it is extended in the test class  .
		// URL will launch from Base class because variable is created in the base class 
				// Open url ..
				driver.get(url);
		// Which runtime  information we want to log will write the statement for that .				
				logger.info("URL Opened");		

	}
// Created the method for quit the browser  ..

//	@AfterClass // that will execute at last ...
//	public void tearDown() {
//		driver.close();		
//		driver.quit();
//	}

	public void captureScreenshot(WebDriver driver, String testName) throws IOException //It takes two parameter WebDriver and test's name  ..
	{
// Created TakeScreenshot interface object then type casted WebDriver into TakeScreenshot interface  ..		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
// Called getScreenshotAs method to create screenshot  image file and stored the file in the File object(src)	..
		File src = screenshot.getScreenshotAs(OutputType.FILE);
// Created one more file object for give the complete path to store the file along with file extension(.png) ..		
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");// Copy image file to destination(which is screenshots folder) for that used the FileUtils method ..		
		FileUtils.copyFile(src, dest);
		
	}	
	
	
}

