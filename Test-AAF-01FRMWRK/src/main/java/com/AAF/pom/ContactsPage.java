package com.AAF.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Contact']")
	private WebElement Contact;
	
    @FindBy(id = "recipient-email")
    private WebElement emailField;

    @FindBy(id = "recipient-name")
    private WebElement nameField;

    @FindBy(id = "message-text")
    private WebElement messageField;

    @FindBy(xpath = "//button[text()='Send message']")
    private WebElement sendButton;
    
    public ContactsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickSignlink() {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",sendButton);
    	//SignUp.click();
	}
    
    public void clickContact() {
    	Contact.click();
    }

    public void sendMessage(String email, String name, String message) {
        emailField.sendKeys(email);
        nameField.sendKeys(name);
        messageField.sendKeys(message);
        sendButton.click();
    }
}