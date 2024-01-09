package cubes.pages.posts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostsListPage {
	
	private String url;
	private WebDriver driver;
	
	private WebElement addNewPostWebElement;
	
	private WebElement searchWebElement;
	
	public PostsListPage(WebDriver driver) {
		
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts"; 
		this.driver = driver;
		
		this.driver.get(url);
		this.driver.manage().window().maximize();
		
		this.addNewPostWebElement = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		
	}
	
	public void openPage() {
		driver.get(url);
	}
	
	public boolean isOnPage() {
		return driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	public void clickOnAddNewPostButton() {
		addNewPostWebElement.click();
	}
	
	//Search web element
	
	public void searchTitle(String titleName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchPostWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control form-control-sm']")));
		searchPostWebElement.clear();
		searchPostWebElement.sendKeys(titleName);
	}
	

	
	
	//IS POST TITLE ON PAGE
	
	public boolean isTitleOnPage(String titleName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement postListItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '" + titleName + "')]")));
		return postListItem.getText().equalsIgnoreCase(titleName);
	}
	
	
	//CLICK ON VIEW BUTTON
	public void clickOnViewButton(String titleName) {
		WebElement viewWebElement = driver.findElement(By.xpath("//td[text()='"+titleName+"']//ancestor::tr/td[12]/div[1]/a[1]"));
		viewWebElement.click();
	}
	
	//DISABLE BUTTON
	public void clickOnDisableButton(String titleName) {
		WebElement disableWebElement = driver.findElement(By.xpath("//td[text()='"+titleName+"']//ancestor::tr/td[12]/div[2]/button[1]"));
		disableWebElement.click();
	
	}
	
	//cancel
	public void clickOnDisableDialogCancelButton() {
		WebElement cancelWebElement = driver.findElement(By.xpath("//form[@id='disable-modal']//button[contains(.,'Cancel')]"));
		cancelWebElement.click();
	}
	
	//disable
	public void clickOnDisableDialogButton() {
		WebElement disableWebElement = driver.findElement(By.xpath("//button[contains(.,'Disable')]"));
		disableWebElement.click();
	}
	
	
	//close
	public void clickOnDisableDialogCloseButton() {
		WebElement closeWebElement = driver.findElement(By.xpath("//button[@class='close']"));
		closeWebElement.click();
	}
	
	
	//ENABLE BUTTON
	public void clickOnEnableButton(String titleName) {
		WebElement enableWebElement = driver.findElement(By.xpath("//td[text()='"+titleName+"']//ancestor::tr/td[12]/div[2]/button[1]"));
		enableWebElement.click();
		
	}
	
	//enable
	public void clickOnEnableDialogButton() {
		WebElement enableWebElement = driver.findElement(By.xpath("//button[contains(.,'Enable')]"));
		enableWebElement.click();
	}
	
	
	//set as unimportant
	public void setAsUnimportant(String titleName) {
		WebElement unimportantWebElement = driver.findElement(By.xpath("//td[text()='"+titleName+"']//ancestor::tr/td[12]/div[2]/button[2]"));
		unimportantWebElement.click();
	}
	
	//set as unimportant in pop up
	public void setAsUnimportantDialogButton() {
		WebElement unimportantWebElement = driver.findElement(By.xpath("//button[contains(.,'Set as Unimportant')]"));
		unimportantWebElement.click();
	}

}
