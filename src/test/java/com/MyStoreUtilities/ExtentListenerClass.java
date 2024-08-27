package com.MyStoreUtilities;

import java.io.File;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

// Interface is implemented with the key implement, while class is extended with the key extends  	.. 

// Created objects of the below classes ..
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

// Created configure method for configure htmlReports and ExtentRepoorts  ..	
	public void configureReport() {
// Now we ll initialize the objects   ..
		htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");// Here has to pass Report name as an
																			// argument which to be generated ..
																			// in the project after test case execution
																			// ..
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
//Adding system information/environment info in the report for that need to call setSystemInfo method which takes 2 parameter- Key & Value
		// Which information storing in the report that has to give as parameter- Key(in
		// which machine is using for the testing) and value(Machine's name)
		reports.setSystemInfo("Machine", "TestPc1");
		reports.setSystemInfo("OS", "Window11");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("User Name", "Sindhu Kumari");
//For changing the look and feel of the html report will call the configuration method by using the htmlReporter class object  ..
		htmlReporter.config().setDocumentTitle("Extent Listener ReportDemo"); // Give the html report document title name .
		htmlReporter.config().setReportName("First Listener ReportDemo");
		htmlReporter.config().setTheme(Theme.DARK);
	}

//ITestListener method- OnStart method is called when any test start,it invoke only one time when test case starts  ..
	public void OnStart(ITestResult Result) {
		configureReport();
		System.out.println("On start method invoked");
	}

	public void onFinish(ITestResult Result) {
// OnFinish method is called after all the test cases are executed, its invoked only one time at last ..	
		System.out.println("On finish method invoked");
		reports.flush(); // It is mandatory to call flush method otherwise whatever we written in the
							// html report that will not be address in the extent report .. ..
	}

	public void onTestFailure(ITestResult Result) {
// Result.getName()- method retrieves the test methods that encountered a fail  ..
		System.out.println("Name of teest metod failed" + Result.getName());
// create method - create a new test entry in the report with the name of the failed test method  ..
		test = reports.createTest(Result.getName());
// We have logged the information in the html report by using the test object of ExtentTest  ..		
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.PINK));

		String screenshotPath = System.getProperty("user.dir") + "//Screenshots//" + Result.getName() + ".png";
//creates a new File object representing the screenshot file located at the constructed path.		
		File screenshotFile = new File(screenshotPath);

		// This checks if the screenshot file actually exists at the specified path.
		if (screenshotFile.exists()) {
// When failed the test case addScreenCaptureFromPath will take screenshot and save in the provided path . 			
			test.fail("Capture screenshot :" + test.addScreenCaptureFromPath(screenshotPath));

		}
	}

// When test case get skipped this method is called  ..
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of the skipped teest case" + Result.getName());

		test = reports.createTest(Result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(), ExtentColor.YELLOW));

	}

// When test get started this method called  ..
	public void OnTestStart(ITestResult Result) {
		System.out.println("Name of the test method started" + Result.getName());
	}

// When test case get pass  ..
	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of the pass test case: " + Result.getName());

		test = reports.createTest(Result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the pass test case is: " + Result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailedWithInSuccessPercentage() {

	}
//...............All the ITestListener method are abstract methods..................
// 	Where test object is used, those methods are ExtentTest  methods .......
// For integrate ITestListener to test class we have to make entry of ExtentListenerClass into testng.xml file and it will use for all test classes ..
//	<listeners>
//	<listener class-name="com.MyStoreUtilities.ExtentListenerClass"></listener>
//</listeners>
}
