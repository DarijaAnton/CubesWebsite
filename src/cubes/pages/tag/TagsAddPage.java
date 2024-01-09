package cubes.pages.tag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TagsAddPage {
	
	private String url;
	private WebDriver driver;
	
	//@FindBy (xpath = "//input[@name='name']") DRUGI NACIN KAKO DA SE STAVE LOKATORI
	private WebElement tagNameWebElement;
	
	private WebElement buttonSaveWebElement;
	private WebElement buttonCancelWebElement;
	
	
	public TagsAddPage (WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/tags/add";
		//Necemo da idemo driver.get(url) jer zelimo da sami kliknemo na dugme
		this.driver = driver;
		
		//PageFactory.initElements(driver, this); UZ OVAJ GORE KOMENTAR
		
		this.tagNameWebElement = driver.findElement(By.xpath("//input[@name='name']"));
		this.buttonSaveWebElement = driver.findElement(By.xpath("//button[@type='submit']"));
		this.buttonCancelWebElement = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));
	}
	
	public void openPage() {
		this.driver.get(url);
	}
	
	public boolean isOnPage() {
		return this.driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void clickOnSave() {
		buttonSaveWebElement.click();
	}
	
	public void clickOnCancel() {
		buttonCancelWebElement.click();
	}
	
	public void insertName(String name) {
		tagNameWebElement.clear();
		tagNameWebElement.sendKeys(name);
	}
	
	public String getName() {
		// return tagNameWebElement.getText(); ovo ne vazi za input polja
		return tagNameWebElement.getAttribute("value");
	}
	
	public boolean isErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.id("name-error"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public boolean isNameAlreadyTakenErrorOnPage (String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//div[@class='invalid-feedback']/div[1]"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	

}
