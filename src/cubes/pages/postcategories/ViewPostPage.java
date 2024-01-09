package cubes.pages.postcategories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewPostPage {
	
	private String url;
	private WebDriver driver;
	
	public ViewPostPage(WebDriver driver) {
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/posts";
		this.driver = driver;
		
		
		
	}
	
	public void openPage() {
		this.driver.get(url);
		
	}
	
	public boolean isOnPage() {
		return this.driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	
	
	public boolean isCategoryNameOnPage(String categoryName) {
		WebElement nameWebElement = driver.findElement(By.xpath("//h2[@class='mb-3']"));
		String categoryNameString = nameWebElement.getText();
		
		return categoryNameString.contains(categoryName);
	}
	


}
