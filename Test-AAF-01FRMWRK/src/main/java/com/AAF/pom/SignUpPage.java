package com.AAF.pom;

import java.util.concurrent.TimeUnit;



import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebElement;



public class SignUpPage {	

	

	    WebDriver driver;

	    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	    

	    @FindBy(xpath="//a[text()='Sign up']")

	    public WebElement SignUp;



	    @FindBy(xpath="//input[@id='sign-username']")

	    public WebElement userName;



	    @FindBy(xpath="//input[@id='sign-password']")

	    public WebElement password;



	    @FindBy(xpath="//button[text()='Sign up']")  // Updated XPath to match button element

	    public WebElement SignUpBtn;

	    

	    @FindBy(xpath="(//span[text()='×'])[2]")

	    public WebElement closebtn;

	    

	    public SignUpPage(WebDriver driver) {

	        this.driver = driver;

	        PageFactory.initElements(driver, this);

	    }

	    

	    public void clickSignlink() {

	    	JavascriptExecutor js=(JavascriptExecutor)driver;

			js.executeScript("arguments[0].click();",SignUp);

	    	//SignUp.click();

		}

	    

	    public void signUp(String username, String pass) {

		 	userName.sendKeys(username);

		 	password.sendKeys(pass);

	        SignUpBtn.click();

	        closebtn.click();

	    }

	    

	  

	}

