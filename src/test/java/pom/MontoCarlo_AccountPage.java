package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MontoCarlo_AccountPage {
	
	@FindBy(xpath="//li[@data-item-title='HOME FURNISHING']")
	private WebElement homeFurnishing;
	
	@FindBy(xpath="//a[contains(text(),'AC Comforter')]")
	private WebElement accomforter;
	
	@FindBy(xpath="//a[@href='/search']")
	private WebElement searchbar;
	
	@FindBy(css="input[name='q']")
	private WebElement productname;
	
	@FindBy(xpath="//span[contains(text(),'Brown Cotton')]")
	private WebElement fourthItem;
	
	@FindBy(xpath="//li[@data-item-title='MEN']")
	private WebElement menhower;
	
	@FindBy(xpath="(//a[contains(text(),'Round Neck Sweaters')])[1]")
	private WebElement roundNeck;
	
	@FindBy(xpath="//span[contains(text(),'Women Maroon Solid Hooded Full Sleeve Jacket')]")
	private WebElement womenhooded;
	
	@FindBy(xpath="//h3[text()='Addresses']")
	private WebElement address;
	
	@FindBy(xpath="(//a[text()='WOMEN'])[1]")
	private WebElement women;
	
	public MontoCarlo_AccountPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHomeFurnishing() {
		return homeFurnishing;
	}
	public void acComforter() {
		accomforter.click();
	}
	public void searchBar() {
		searchbar.click();
	}
	public void productName(String name) {
		productname.sendKeys(name);
	}
	public void fourthItem() {
		fourthItem.click();
	}
	public WebElement mensHower() {
		return menhower;
	}
	public void roundNeck() {
		roundNeck.click();
	}
	public void womenHooded() {
		womenhooded.click();
	}
	public void address() {
		address.click();
	}
	public void womenSection() {
		women.click();
	}

	
	
}
