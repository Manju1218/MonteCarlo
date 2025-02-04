package genericlibraries;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners(Listners1.class)
public class BaseClass 
{
	public static WebDriver driver;
	public DataUtilities datautilities = new DataUtilities();
	public WebDriverUtilities utilities = new WebDriverUtilities();
	
	@BeforeMethod
	public void openApp() throws EncryptedDocumentException, IOException 
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(datautilities.readingdataExcelFile("sheet1", 1, 0));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.quit();		
	}
}
