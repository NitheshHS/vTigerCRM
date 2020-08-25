package com.vTiger.GenericLib;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerIMP1 implements ITestListener{
	ExtentHtmlReporter htmlReport;
	ExtentReports reports;
	ExtentTest test;

	
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+" test started");
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" test passed");
		
	}

	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		WebdriverUtils wLib=new WebdriverUtils();
		String imagePath = wLib.getScreenshot(BaseClass.staticDriver, result.getMethod().getMethodName());
		try {
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	
	public void onStart(ITestContext context) {
		htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
		htmlReport.config().setDocumentTitle("vTiger CRM");
		htmlReport.config().setReportName("RegressionTest");
		htmlReport.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Application Name", "vTiger");
		reports.setSystemInfo("Build version", "5.4.0");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Reporter Name", "NitheshHS");
	}


	public void onFinish(ITestContext context) {
		reports.flush();
		
	}

}
