package com.AAF.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{ 
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="signin2")
	private WebElement signUpButton;
	
	@FindBy(id="login2")
	private WebElement loginButton;
	
	@FindBy(linkText="Contact")
	private WebElement contactTab;
	
	@FindBy(id="cartur")
	private WebElement cartButton ;
	
	
	
	 public void clickSignUp() {
	        signUpButton.click();
	    }

	    public void clickLogin() {
	        loginButton.click();
	    }

	    public void clickContactTab() {
	        contactTab.click();
	    }

	    public void clickCart() {
	        cartButton.click();
	    }
}
