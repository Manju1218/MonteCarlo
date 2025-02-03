package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarlo_AcComforterPage {
	
	@FindBy(xpath="//button[text()='Size']")
	private WebElement size;
	
	@FindBy(css="//label[contains(text(),'Single ')]")
	private WebElement selectingsize;
	
	@FindBy(xpath="//button[text()='Color']")
	private WebElement colour;
	
	@FindBy(css="label[class='color-swatch__item']")
	private WebElement selectcolour;

	@FindBy(xpath="//button[text()='Brand']")
	private WebElement brand;
	
	@FindBy(xpath="//label[text()='Monte Carlo (41)‎']")
	private WebElement selectbrand;
	
	@FindBy(xpath="//button[text()='Availability']']")
	private WebElement availability;
	
	@FindBy(xpath="//label[text()='In stock (7)‎']")
	private WebElement selectavailability;
	
	@FindBy(xpath="(//img[@loading='lazy'])[7]")
	private WebElement product;
	
	@FindBy(xpath="//label[contains(text(),'38/M ')]")
	private WebElement test2size;
	
	@FindBy(xpath="//label[contains(text(),'Rock.it')]")
	private WebElement brandRock;
	
	@FindBy(xpath="//button[text()='Sleeve']")
	private WebElement sleeve;
	@FindBy(xpath="//label[contains(text(),'Full Sleeve ')]")
	private WebElement selectsleeve;
	@FindBy(xpath="(//img[@class='product-item__secondary-image'])[3]")
	private WebElement thirdItem;
	@FindBy(xpath="(//div[@class='custom-tems slick-slide slick-active'])[4]")
	private WebElement stole;
	@FindBy(xpath="(//input[@aria-label='To price'])[2]")
	private WebElement price;
	@FindBy(xpath="(//input[@aria-label='To price'])[2]")
	private WebElement clickprice;
	
	@FindBy(xpath="//h3[@class='heading h4']")
	private WebElement noresult;
	
	@FindBy(xpath="(//a[@class='button button--primary'])[2]")
	private WebElement resetfilter;
	@FindBy(id="filter.v.price.gte")
	private WebElement firstprice;
	
	@FindBy(xpath="(//a[@class='product-item__aspect-ratio aspect-ratio '])[1]")
	private WebElement firstProduct;
	
	public MonteCarlo_AcComforterPage(WebDriver driver) {
		PageFactory.initElements(driver,this);

	}
	
	public void clickSize() {
		size.click();
	}
	public void chooseSize() {
		selectingsize.click();
	}
	public void clickColour() {
		colour.click();
	}
	public void chooseColour() {
		selectcolour.click();
	}
	public void clickBrand() {
		brand.click();
	}
	public void chooseBrand() {
		selectbrand.click();
	}
	public void clickAvailability() {
		availability.click();
	}
	public void chooseAvailability() {
		selectavailability.click();
	}
	public void chooseProduct() {
		product.click();
	}
	public void testtwoSize() {
		test2size.click();
	}
	public void brandRock() {
		brandRock.click();
	}
	public void sleeve() {
		sleeve.click();
	}
	public void sleeveSelect() {
		selectsleeve.click();
	}
	public void thirdItem() {
		thirdItem.click();
	}
	public void selectStole() {
		stole.click();
	}
	public void priceRange(String priceRange) {
		price.sendKeys(priceRange);
		price.sendKeys(Keys.ENTER);
	}
	public String noResult() {
		return noresult.getText();
	}
	public void resetFilter() {
		resetfilter.click();
	}
	public void firstPrice(String price) {
		firstprice.sendKeys(price);
	}
	public void firstProduct() {
		firstProduct.click();
	}

}
