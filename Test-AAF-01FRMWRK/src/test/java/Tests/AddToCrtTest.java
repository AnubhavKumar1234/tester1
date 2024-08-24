package Tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCrtTest 
{
	@Test
	public void cartValidation() throws InterruptedException
	{
//       WebDriverManager.chromedriver().setup();
//	// Create an instance of the ChromeDriver
//	WebDriver driver = new ChromeDriver();
//	driver.get("https://www.demoblaze.com/");
//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//	
//	driver.findElement(By.linkText("Samsung galaxy s7")).click();
//	driver.findElement(By.linkText("Add to cart")).click();
	
	WebDriverManager.chromedriver().setup();



	// Create an instance of the ChromeDriver

	WebDriver driver = new ChromeDriver();

	driver.navigate().to("https://www.demoblaze.com/");
	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);



	driver.findElement(By.xpath("//a[text()='Samsung galaxy s7']")).click();

			

			driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
			WebDriverWait wait = new

					WebDriverWait(driver,Duration.ofSeconds(10));

			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();

			alert.accept();
	
			driver.findElement(By.xpath("//a[text()='Home ']")).click();
			driver.findElement(By.linkText("Laptops")).click();
			WebElement macbookpro = driver.findElement(By.linkText("MacBook Pro"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",macbookpro);
			macbookpro.click();
			driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
			WebDriverWait wait1 = new

					WebDriverWait(driver,Duration.ofSeconds(10));

			wait1.until(ExpectedConditions.alertIsPresent());
			Alert alert1 = driver.switchTo().alert();

			alert1.accept();
			driver.findElement(By.xpath("//a[text()='Home ']")).click();
			driver.findElement(By.linkText("Monitors")).click();
			WebElement monitor = driver.findElement(By.linkText("Apple monitor 24"));
			js.executeScript("arguments[0].scrollIntoView();",monitor);
			monitor.click();
			driver.findElement(By.xpath("//a[text()='Add to cart']")).click();

			//driver.switchTo().alert().accept(); 

			WebDriverWait wait2 = new

					WebDriverWait(driver,Duration.ofSeconds(10));

			wait2.until(ExpectedConditions.alertIsPresent());



			// Switch to the alert and accept it 

			Alert alert2 = driver.switchTo().alert();

			alert2.accept(); 

			driver.findElement(By.xpath("//a[text()='Cart']")).click();
			Thread.sleep(5000);

			String totalPrice= driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
	

			System.out.println(totalPrice);

			String expectedPrice = "2300";

			Assert.assertEquals(totalPrice,expectedPrice);
			System.out.println("Validation success");
	
	
	}
	

}
