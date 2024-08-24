package Tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AAF.pom.LoginPage;
import com.AAF.pom.SignUpPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpTest {

		
		@Test
		public void LoginSuccess() throws InterruptedException
		{
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver;
			driver = new ChromeDriver();
			SignUpPage sn=new SignUpPage(driver);
			LoginPage lp=new LoginPage(driver);
			// Create an instance of the ChromeDriver

			 

			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

			driver.get("https://www.demoblaze.com/");

			driver.manage().window().maximize();


			driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		   
			sn.signUp("Anubhav1235","2020@Jai");
			
			

			//driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys("Anubhav1235");

			//driver.findElement(By.xpath("//input[@id='sign-password']")).sendKeys("2020@Jai");

//			WebElement close=driver.findElement(By.xpath("//button[text()='Close']"));
//
//			driver.findElement(By.xpath("//button[text()='Sign up']")).click();

			WebDriverWait wait = new

					WebDriverWait(driver,Duration.ofSeconds(10));

			wait.until(ExpectedConditions.alertIsPresent());



			// Switch to the alert and accept it 

			Alert alert = driver.switchTo().alert();

			String actual=alert.getText() ;

			System.out.println(actual);

			Assert.assertEquals(actual, "This user already exist.");

			alert.accept();

			

			/*

			 * JavascriptExecutor js=(JavascriptExecutor)driver;

			 * js.executeScript("arguments[0].click();", close);

			 */

			

			//driver.findElement(By.xpath("(//span[text()='×'])[2]")).click();

			//driver.findElement(By.xpath("//button[text()='Close']")).click();

			driver.findElement(By.xpath("//a[text()='Log in']")).click();

			//loginusername

			//loginpassword
            lp.login("Anubhav1235","2020@Jai");
			//driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("Anubhav1235");

			//driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("2020@Jai");

			//Log in

			//driver.findElement(By.xpath("//button[text()='Log in']")).click();

			Thread.sleep(5000);

			String actuall=driver.findElement(By.id("nameofuser")).getText();

			

			System.out.println(actuall);

			String Expectedd="Welcome Anubhav1235";

			Assert.assertEquals(actuall, Expectedd);
		}
	

}
