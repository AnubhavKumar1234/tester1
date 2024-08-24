package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AAF.pom.ContactsPage;
import com.AAF.pom.LoginPage;
import com.AAF.pom.PlaceOrderPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactMessageValidationTest  
{
	WebDriver driver;
	LoginPage lp= new LoginPage(driver);
    
    ContactsPage cp= new ContactsPage(driver); 
    // 
    
    @SuppressWarnings("deprecation")
	@BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        
    }

    @Test(priority = 1)
    public void login() throws InterruptedException  {
        lp.clickLoginlink();
        lp.login("Anubhav1235","2020@Jai");
        Thread.sleep(3000);
    }
    
    @Test(dataProvider="ContactMessageData", priority = 2)
    public void contactMessageValid(String Email, String Name, String Message) {
        cp.clickContact();
        cp.sendMessage(Email, Name, Message);
        String actual=driver.switchTo().alert().getText();
        Assert.assertEquals(actual, "Thanks for the message!!");
        driver.switchTo().alert().accept();;
        
    }
    //Scenario-2
    @DataProvider(name = "ContactMessageData")    
    public Object[][] getData() throws Exception {
        File file = new File("./TestData/ContactFeildsData.xlsx");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbookFactory workbook = new HSSFWorkbookFactory();
        Workbook wb = workbook.create(fis);
        Sheet sh = wb.getSheet("Sheet1");

        int noOfRows = sh.getPhysicalNumberOfRows();
        int noOfColumns = sh.getRow(0).getLastCellNum();

        String[][] data = new String[noOfRows - 1][noOfColumns];
        DataFormatter df = new DataFormatter();

        for (int i = 1; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                data[i - 1][j] = df.formatCellValue(sh.getRow(i).getCell(j));
            }
        }

        wb.close();
        fis.close();
        return data;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
