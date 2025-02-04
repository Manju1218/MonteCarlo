package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarlo_CartPage {
	
	@FindBy(xpath="//a[@href='/collections/all']")
	private WebElement startShopping;

	@FindBy(xpath = "(//span[@class='popover__choice-label'])[7]")
	private WebElement date;
	
	@FindBy(css = "img[data-media-id='35424980205856']")
	private WebElement selProduct;
	
	@FindBy(xpath = "//button[@class='popover-button hidden-pocket']")
	private WebElement filterDate;
	@FindBy(xpath="//span[text()='Price, high to low']")
	private WebElement highToLow;
	
	@FindBy(xpath="(//a[contains(text(),' Cotton')])[10]")
	private WebElement productTC10;
	
	@FindBy(id="order-note-toggle")
	private WebElement addEditNote;
	
	@FindBy(xpath="//textarea[@is='cart-note']")
	private WebElement cartNote;
	@FindBy(xpath="//button[@name='checkout']")
	private WebElement initiateCheckout;
	
 
	public MonteCarlo_CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);

	}
	public void filter() {
		filterDate.click();
	}
	public void date() {
		date.click();
	}
	public void startShooping() {
		startShopping.click();
	}
	public void selectPro() {
		selProduct.click();
	}
	public void HighToLow() {
		highToLow.click();
	}
	public void selectItem() {
		productTC10.click();
	}
	public void addEdit() {
		addEditNote.click();
	}
	public void cartNote(String note) {
		cartNote.sendKeys(note);
	}
	public void initiateCheckout() {
		initiateCheckout.click();
	}
	public void selectPro10() {
		productTC10.click();
	}
}
