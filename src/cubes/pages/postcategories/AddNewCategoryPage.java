package cubes.pages.postcategories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewCategoryPage {
	
	private String url;
	private WebDriver driver;
	
	private WebElement insertNameWebElement;
	private WebElement insertDescriptionWebElement;
	private WebElement buttonSaveWebElement;
	private WebElement buttonCancelWebElement;
	
	public AddNewCategoryPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/add";
		this.driver = driver;
		
		this.insertNameWebElement = driver.findElement(By.xpath("//input[@name='name']"));
		this.insertDescriptionWebElement = driver.findElement(By.xpath("//textarea[@name='description']"));
		this.buttonSaveWebElement = driver.findElement(By.xpath("//button[@type='submit']"));
		this.buttonCancelWebElement = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));
		
		
		
	}
	
	public void openPage() {
		this.driver.get(url);
		
	}
	
	public boolean isOnPage() {
		return this.driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void clickOnSaveButton() {
		buttonSaveWebElement.click();
	}
	
	public void clickOnCancelButton() {
		buttonCancelWebElement.click();
	}
	
	public void insertName(String name) {
		insertNameWebElement.clear();
		insertNameWebElement.sendKeys(name);
	}
	
	public void insertDescription(String description) {
		insertDescriptionWebElement.clear();
		insertDescriptionWebElement.sendKeys(description);
	}
	
	public String getName() {
		return insertNameWebElement.getAttribute("value");
	}
	
	public String getDescription() {
		return insertDescriptionWebElement.getAttribute("value");
	}
	
	public boolean isNameErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.id("name-error"));
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public boolean isDescriptionErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.id("description-error"));
		
		//return errorWebElements.size()>0;
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public boolean isDescriptionCharactersErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//div[text()='The description must be at least 50 characters.']"));
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	
	public boolean isNameAlreadyTakenErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//div[@class='invalid-feedback']/div[1]"));
		return errorWebElement.getText().equalsIgnoreCase(error);
	}

}
