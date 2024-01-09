package cubes.pages.postcategories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostCategoriesListPage {
	
	private String url;
	private WebDriver driver;
	
	private WebElement addNewCategoryWebElement;
	
	public PostCategoriesListPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories";
		this.driver = driver;
		
		this.driver.get(url);
		this.driver.manage().window().maximize();
		
		this.addNewCategoryWebElement = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
	}
	
	public void openPage() {
		driver.get(url);
	}
	
	public boolean isOnPage() {
		return driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void clickOnAddNewCategoryButton() {
		addNewCategoryWebElement.click();
	}
	
	public void clickOnViewButton(String categoryName) {//proveriti putanju
		WebElement viewWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[6]/div[1]/a[1]"));
		viewWebElement.click();
	}
	
	public void clickOnEditButton(String categoryName) {
		WebElement editWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[6]/div[1]/a[2]"));
		editWebElement.click();
	}
	
	public void clickOnDeleteButton(String categoryName) {
		WebElement deleteWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[6]/div[1]/button[1]"));
		deleteWebElement.click();
	}
	
	public void clickOnDeleteDialogCancelButton() {
		WebElement cancelWebElement = driver.findElement(By.xpath("//button[text()='Cancel']"));
		cancelWebElement.click();
	}
	
	public void clickOnDeleteDialogDeleteButton() {
		WebElement deleteWebElement = driver.findElement(By.xpath("//button[text()='Delete']"));
		deleteWebElement.click();
	}
	
	public void clickOnDeleteDialogCloseButton() {
		WebElement closeWebElement = driver.findElement(By.xpath("//button[@class='close']"));
		closeWebElement.click();
	}
	
	
	
	public boolean isCategoryNameOnPage(String categoryName) {
		List<WebElement> webElements = driver.findElements(By.xpath("//strong[text()='"+categoryName+"']"));
		
		return webElements.size()>0;
	}
	
	public boolean isCategoryDescriptionOnPage (String categoryDescription, String categoryName) {
		WebElement descriptionWebElement = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']//ancestor::tr/td[3]"));
		
		String descriptionString = descriptionWebElement.getText().replace("...", "");

		return categoryDescription.contains(descriptionString);
	}

}
