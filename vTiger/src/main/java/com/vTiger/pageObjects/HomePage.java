package com.vTiger.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.GenericLib.WebdriverUtils;
/**
 * HomePage of vTiger crm
 * @author NitheshHS
 *
 */
public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[contains(@src,'user.PNG')]")
	private WebElement AdministratorIMG;
	
	@FindBy(linkText="Sign Out")
	private WebElement sigoutLink;
	
	
	public WebElement getAdministratorIMG() {
		return AdministratorIMG;
	}

	public WebElement getSigoutLink() {
		return sigoutLink;
	}
	
	public void logout() {
		WebdriverUtils wLib=new WebdriverUtils();
		wLib.moveMouseToElementAndClick(driver, AdministratorIMG);
		sigoutLink.click();
	}
	

}
