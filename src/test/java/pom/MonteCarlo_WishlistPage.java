package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarlo_WishlistPage {
	
	@FindBy(xpath="//button[text()='Add to Cart']")
	private WebElement addtocart;
	@FindBy(xpath="//span[text()='Cart']")
	private WebElement cart;
	
	@FindBy(xpath="(//button[contains(text(),'Add to Cart')])[1]")
	private WebElement mouseHower;
	
	@FindBy(xpath="//p[@class='flits-product-name flits-link flits-text-ellipsis']")
	private WebElement bedSheetVerify;
	
	
	public MonteCarlo_WishlistPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void addToCart() {
		addtocart.click();
	}
	public void clickCart() {
		cart.click();
	}
	public WebElement mouseHower() {
		
		return mouseHower;	
	}
	public String bedSheet() {
		return bedSheetVerify.getText();
	}
	public WebElement webEleWailadd() {
		return addtocart;
	}
	
//	(//button[@class="flits-button flits-primary-btn flits-remove-product"])[1]
}
