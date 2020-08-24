package com.vTiger.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTiger.GenericLib.FileLib;
/**
 * 
 * @author NitheshHS
 *
 */
public class LoginPage {
	WebDriver driver;
	/*
	 * login page constructor
	 */
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * Locators
	 */
	@FindBy(name="user_name")
	private WebElement userNameTF;

	@FindBy(name="user_password")
	private WebElement passwordTF;

	@FindBy(id="submitButton")
	private WebElement submitBT;

	/*
	 * getters method
	 */
	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSubmitBT() {
		return submitBT;
	}
	
	/**
	 * username and password reqired to enter home page
	 * @param username
	 * @param password
	 */
	public void login(String username,String password) {
		userNameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		submitBT.click();
		
	}
	/**
	 * Provide direct access of home page 
	 * @throws Throwable
	 */
	public void login() throws Throwable {
		FileLib fLib=new FileLib();
		userNameTF.sendKeys(fLib.getPropertyKeyValue("username"));
		passwordTF.sendKeys(fLib.getPropertyKeyValue("password"));
		submitBT.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
