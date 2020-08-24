package com.vTiger.GenericLib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerIMP implements ITestListener{
	WebDriver driver;
	ExtentHtmlReporter htmlReport;
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+"test is started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" test is passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" test is failed");
		test.log(Status.FAIL, result.getThrowable());
		WebdriverUtils wLib=new WebdriverUtils();
		String imagePath = wLib.getScreenshot(BaseClass.staticDriver, result.getMethod().getMethodName());
		try {
			test.addScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" test is skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		htmlReport=new ExtentHtmlReporter("./extentreport.html");
		htmlReport.config().setDocumentTitle("vTiger CRM");
		htmlReport.config().setReportName("vTiger");
		htmlReport.config().setTheme(Theme.DARK);

		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Reporter", "NitheshHS");
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("Application", "vTiger crm");

	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();

	}

}
