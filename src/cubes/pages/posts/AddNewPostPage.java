package cubes.pages.posts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AddNewPostPage {
	
	private String url;
	private WebDriver driver;
	
	
	private WebElement chooseCategoryWebElement;
	private WebElement insertTitleWebElement;
	private WebElement insertDescriptionWebElement;
	private WebElement radioButtonImportantWebElement;
	//private WebElement checkBoxTagsWebElement;
	protected WebElement uploadPhotoWebElement;
	//private WebElement insertContentWebElement;
	private WebElement buttonSaveWebElement;
	private WebElement buttonCancelWebElement;
	
	public AddNewPostPage(WebDriver driver) {
		
		this.url = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add"; 
		this.driver = driver;
		
		this.chooseCategoryWebElement = driver.findElement(By.name("post_category_id"));
		this.insertTitleWebElement = driver.findElement(By.xpath("//input[@name='title']"));
		this.insertDescriptionWebElement = driver.findElement(By.xpath("//textarea[@name='description']"));
		this.radioButtonImportantWebElement = driver.findElement(By.xpath("//label[@for = 'set-as-important']"));
		//this.checkBoxTagsWebElement = driver.findElement(By.xpath("//label[@for='tag-checkbox-1332']"));
		this.uploadPhotoWebElement = driver.findElement(By.xpath("//input[@name='photo']"));
		this.buttonSaveWebElement = driver.findElement(By.xpath("//button[@type='submit']"));
		this.buttonCancelWebElement = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));
		
	
		
	}
	
	public void openPage() {
		this.driver.get(url);
		
	}
	
	
	public boolean isOnPage() {
		return this.driver.getCurrentUrl().equalsIgnoreCase(url);
	}
	
	//SAVE BUTTON
	public void clickOnSaveButton() {
		buttonSaveWebElement.click();
	}
	
	//CANCEL BUTTON
	public void clickOnCancelButton() {
		buttonCancelWebElement.click();
	}
	
	//CHOOSE CATEGORY
	public void chooseCategory(String categoryName) {
		
		Select chooseCategory = new Select(chooseCategoryWebElement);
		chooseCategory.selectByVisibleText(categoryName);
	}
	
	//IMPORTANT!
	public void selectRadioButton() {
	    radioButtonImportantWebElement.click();
	}
	
	
	//CHOOSE TAG
	public void chooseTag(String tagName) {
		WebElement tagWebElement = driver.findElement(By.xpath("//label[text()='" + tagName + "']"));
		tagWebElement.click();
	}
	
	//TAG ERROR
	public boolean isTagErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//span[@id='tag_id[]-error']"));
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	
	
	//UPLOAD PHOTO 
	public void uploadPhoto(String photo) {
		uploadPhotoWebElement.sendKeys(photo);
	}
	
	//INSERT CONTENT
	public void insertContent(String iFrameLocator, String contentLocator, String contentText) {
		
		    // Nalazim iFrame
			WebElement iFrameWebElement = driver.findElement(By.xpath(iFrameLocator));
		    
			//Prebacivanje na iFrame
		    driver.switchTo().frame(iFrameWebElement);
		    
		    //Polje za unos teksta u iFrame-u
		    WebElement contentWebElement = driver.findElement(By.xpath(contentLocator));
		    
		    //Unos tektsa
		    contentWebElement.clear();
		    contentWebElement.sendKeys(contentText);
		    
		    //Vracanje na glavni sadzaj
		    driver.switchTo().defaultContent();
		

	}
	
	
	//CONTENT ERROR
	public boolean isContentErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.xpath("//div[@class='invalid-feedback']"));
		
		return errorWebElement.getText().equalsIgnoreCase(error);
	}

	
	
	//INSERT TITLE
	public void insertTitle(String title) {
		insertTitleWebElement.clear();
		insertTitleWebElement.sendKeys(title);
	}
	
	//TITLE ERROR
	public boolean isTitleErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.id("title-error"));
		return errorWebElement.getText().equalsIgnoreCase(error);
		
	}
	
	
	//INSERT DESCRIPTION
	public void insertDescription(String description) {
		insertDescriptionWebElement.clear();
		insertDescriptionWebElement.sendKeys(description);
	}
	
	//DESCRIPTION ERROR
	public boolean isDescriptionErrorOnPage(String error) {
		WebElement errorWebElement = driver.findElement(By.id("description-error"));
		return errorWebElement.getText().equalsIgnoreCase(error);
	}
	
	//GET TITLE
	public String getTitle() {
		return insertTitleWebElement.getAttribute("value");
	}
	
	//GET DESCRIPTION
	public String getDescription() {
		return insertDescriptionWebElement.getAttribute("value");
	}
	
	
	
	

}
