package com.vTiger.GenericLib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils {
	public void maximizeScreen(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void waitForWebelement(WebDriver driver,int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	public void moveMouseToElementAndClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}

	public void selectDropDownByText(WebDriver driver,WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	public void selectDropdownByIndex(WebDriver driver,WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

	public void selectdropDownByValue(WebDriver driver,WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}

	public void switchToWindow(WebDriver driver,String pageTitle) {
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows) {
			driver.switchTo().window(window);
			String actualTitle = driver.getTitle();
			if(actualTitle.contains(pageTitle)) {
				break;
			}
		}

	}

	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public boolean waitAndClick(WebDriver driver,WebElement element) throws InterruptedException {
		int time=0;
		boolean flag=false;
		while(time<20) {
			try {
				element.click();
				flag=true;
				
				break;
			} catch (Exception e) {
				time++;
				Thread.sleep(1000);
			}
		}
		return flag;
	}
	
	public void waitTillVisibilityofElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public boolean waitTillVisibilityOfElement(WebDriver driver,WebElement element) throws InterruptedException {
		boolean flag=false;
		int time=0;
		while(time<20){
			try {
				element.isDisplayed();
			} catch (Exception e) {
				time++;
				Thread.sleep(1000);
			}
		}
		return flag;
		
		
	}

	public String getScreenshot(WebDriver driver,String methodName) throws IOException {
		String date = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(new Date());
		String path = System.getProperty("user.dir")+"/screenshot/"+methodName+"_"+date+".PNG";
		EventFiringWebDriver event=new EventFiringWebDriver(driver);
		File src = event.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
		
	}



}
