package pom;

import java.util.jar.Attributes.Name;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarlo_AddressPage {
	
	@FindBy(xpath="//button[text()='Add a new address']")
	private WebElement addNewAddress;
	@FindBy(id="address-new[first_name]")
	private WebElement name;
	@FindBy(id="address-new[phone]")
	private WebElement phone;
	@FindBy(id="address-new[address1]")
	private WebElement address;
	@FindBy(id="address-new[zip]")
	private WebElement zip;
	@FindBy(id="address-new[city]")
	private WebElement city;
	@FindBy(id="address-new[default]")
	private WebElement setdefault;
	@FindBy(xpath="//span[text()='Add a new address']")
	private WebElement addaddresssubmit;
	
	@FindBy(xpath="(//div[@class='account__address-details']/p)[2]")
	private WebElement newaddText;
	
	@FindBy(xpath="(//button[@class='link text--subdued'])[2]")
	private WebElement deleteadd;
	
	public MonteCarlo_AddressPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public void addNewAddress() {
		addNewAddress.click();
	}

	public void getName(String namePer) {
		name.sendKeys(namePer);
	}

	public void getPhone(String phno) {
		 phone.sendKeys(phno);
	}

	public void getAddress(String add) {
		 address.sendKeys(add);
	}

	public void getZip(String zipcode) {
		 zip.sendKeys(zipcode);
	}

	public void getCity(String cityName) {
		 city.sendKeys(cityName);
	}
	public void defaultSet() {
		setdefault.click();
	}
	public void addAddressSubmit() {
		addaddresssubmit.click();
	}
	public String textadd() {
		return newaddText.getText();
	}
	public void deleteAdd() {
		deleteadd.click();
	}

}
