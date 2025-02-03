package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MontoCarlo_ProductPage {
	
	@FindBy(css="a[data-tippy-content='Added to Wishlist']")
	private WebElement addwishlist;
	
	@FindBy(xpath="//span[contains(text(),'Wishlist')]")
	private WebElement wishlist;
	
	@FindBy(xpath="//div[@class='product_wishlist']")
	private WebElement addToWishList;
	
	@FindBy(xpath="(//p[contains(text(),'Blue & Brown Cotton 525 GSM Towel Set Pack of 4 (2 Bath & 2 Hand Towels)')])[1]")
	private WebElement getText;
	@FindBy(id="pincode")
	private WebElement pincode;
	
	@FindBy(id="check-pincode")
	private WebElement checkpin;
	
	@FindBy(xpath="(//label[@class='block-swatch__item'])[2]")
	private WebElement selectSize;
	
	@FindBy(xpath="(//button[@class='quantity-selector__button'])[2]")
	private WebElement increaseQty;
	
	@FindBy(xpath="(//span[text()='Add to cart'])[2]")
	private WebElement addtoCart;
	@FindBy(xpath="//button[@form='mini-cart-form']")
	private WebElement checkoutIni;
	@FindBy(xpath="//div[@class='filts-wishlist-product-style flits-wishlist-button-style ']")
	private WebElement wishlistAdd;
	
	@FindBy(xpath="//button[@class='flits-button flits-tingle-btn flits-tingle-primary-btn']")
	private WebElement email;
	
	public MontoCarlo_ProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void addWishList() {
		addwishlist.click();
	}
	public void wishList() {
		wishlist.click();
	}
	public void addToList() {
		addToWishList.click();
	}
	public String gettext() {
		return getText.getText();
	}
	public void enterPincode(String pin) {
		pincode.sendKeys(pin);
	}
	public void checkPin() {
		checkpin.click();
	}
	public void selectSizeWomen() {
		selectSize.click();
	}
	public void increaseQty() {
		increaseQty.click();
	}
	public void addCart() {
		addtoCart.click();
	}
	public void checkInitiate() {
		checkoutIni.click();
	}
	public void wishlistAdd() {
		wishlistAdd.click();
	}
	public String emailHandling() {
		return email.getText();
	}
	}
