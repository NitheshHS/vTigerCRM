package com.vTiger.GenericLib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vTiger.pageObjects.HomePage;
import com.vTiger.pageObjects.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public WebdriverUtils wLib=new WebdriverUtils();
	public FileLib fLib=new FileLib();
	public static WebDriver staticDriver;
	@BeforeSuite
	public void configBS() {

	}
	//@Parameters("browser")
	@BeforeTest
	public void configBT() {
		//		if(browserVar.equals("chrome")) {
		//			driver=new ChromeDriver();
		//		}
		//		else if(browserVar.equals("firefox")) {
		//			driver=new FirefoxDriver();
		//		}	

	}

	@BeforeClass
	public void configBC() throws Throwable {
		if(fLib.getPropertyKeyValue("browser").equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(fLib.getPropertyKeyValue("browser").equals("firefox")) {
			driver=new FirefoxDriver();
		}
		staticDriver=driver;
		wLib.maximizeScreen(driver);
		wLib.waitForWebelement(driver, 10);
		driver.get(fLib.getPropertyKeyValue("url"));
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		LoginPage log=new LoginPage(driver);
		log.login();

	}
	@AfterMethod
	public void configAM() throws IOException {

		HomePage home=new HomePage(driver);
		home.logout();

	}
	@AfterClass
	public void configAC() {
		driver.close();
	}
	@AfterTest
	public void configAT() {

		//report.flush();
	}
	@AfterSuite
	public void congigAS() {

	}
}
