package com.AAF.pom;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;



public class LoginPage {

	

	WebDriver driver;

	



	@FindBy(xpath="//a[text()='Log in']")

	private WebElement login;

	

	@FindBy(id = "loginusername")

    private WebElement usernameField;



    @FindBy(id = "loginpassword")

    private WebElement passwordField;



    @FindBy(xpath = "//button[text()='Log in']")

    private WebElement loginButton;

    

    @FindBy(xpath="(//span[text()='×'])[1]")

    public WebElement closebtn;



    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    

    public void clickLoginlink() {

    	JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].click();",login);

    	//SignUp.click();

	}

   

    public void login(String username, String password) {

    	

        usernameField.sendKeys(username);

        passwordField.sendKeys(password);

        loginButton.click();

    }

    

}