package cubes.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.postcategories.AddNewCategoryPage;
import cubes.pages.postcategories.PostCategoriesListPage;
import cubes.pages.postcategories.ViewPostPage;

public class PostCategoriesTest {
	
	private static WebDriver driver;
	private String categoryName = "Darija";
	
	private String newCategoryName = "Darija1";
	
	private String description = "Ja sam Darija Antonijevic12345678918191919191919191";
	
	private String newDescription = "kakakakkakakakakakakakakakaakkakakakakakakakakkakak";
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = MyWebDriver.getDriver("chrome");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//Leave empty name and description and click on save 
	@Test
	public void tc01() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		postCategoriesListPage.clickOnAddNewCategoryButton();
		
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
		
		assertTrue("Add new category page is not opened", addNewCategoryPage.isOnPage());
		
		addNewCategoryPage.insertName("");
		addNewCategoryPage.insertDescription("");
		
		addNewCategoryPage.clickOnSaveButton();
		
		assertTrue("Name is required field - error is missing", addNewCategoryPage.isNameErrorOnPage("This field is required."));
		assertTrue("Description is required field - error is missing", addNewCategoryPage.isDescriptionErrorOnPage("This field is required."));
	}
	
	//Leave empty name and description and click on cancel
	@Test
	public void tc02() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		postCategoriesListPage.clickOnAddNewCategoryButton();
		
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
		
		assertTrue("Add new category page is not opened", addNewCategoryPage.isOnPage());
		
		addNewCategoryPage.insertName("");
		addNewCategoryPage.insertDescription("");
		
		addNewCategoryPage.clickOnCancelButton();
		
		assertTrue("Post categories list page is not opened", postCategoriesListPage.isOnPage());
	}
	
	//Insert name and leave description empty and click on save
	@Test
	public void tc03() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		postCategoriesListPage.clickOnAddNewCategoryButton();
		
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
		
		assertTrue("Add new category page is not opened", addNewCategoryPage.isOnPage());
		
		addNewCategoryPage.insertName("Darija");
		addNewCategoryPage.insertDescription("");
		
		addNewCategoryPage.clickOnSaveButton();
		
		assertTrue("Description is required field - error is missing", addNewCategoryPage.isDescriptionErrorOnPage("This field is required."));
	}
	
	//Insert name and leave description empty and click on cancel
	@Test
	public void tc04() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		postCategoriesListPage.clickOnAddNewCategoryButton();
		
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
		
		assertTrue("Add new category page is not opened", addNewCategoryPage.isOnPage());
		
		addNewCategoryPage.insertName("Darija");
		addNewCategoryPage.insertDescription("");
		
		addNewCategoryPage.clickOnCancelButton();
		
		assertTrue("Post categories list page is not opened", postCategoriesListPage.isOnPage());
	}
	
	//Insert name and description(under 50 char ) and click on save
	@Test
	public void tc05() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		postCategoriesListPage.clickOnAddNewCategoryButton();
		
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
		
		assertTrue("Add new category page is not opened", addNewCategoryPage.isOnPage());
		
		addNewCategoryPage.insertName("Darija");
		addNewCategoryPage.insertDescription("Ja sam Darija Antonijevic");
		
		addNewCategoryPage.clickOnSaveButton();
		
		assertTrue("Description must be least 50 char - error", addNewCategoryPage.isDescriptionCharactersErrorOnPage("The description must be at least 50 characters."));
	}
	
	//Insert name and description(under 50 char) and click on cancel
	@Test
	public void tc06() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		postCategoriesListPage.clickOnAddNewCategoryButton();
		
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
		
		assertTrue("Add new category page is not opened", addNewCategoryPage.isOnPage());
		
		addNewCategoryPage.insertName("Darija");
		addNewCategoryPage.insertDescription("Ja sam Darija Antonijevic");
		
		addNewCategoryPage.clickOnCancelButton();
		
		assertTrue("Post categories list page not opened", postCategoriesListPage.isOnPage());
		
	}
	
	//Insert name and description(50 char) and click on cancel
	@Test
	public void tc07() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		postCategoriesListPage.clickOnAddNewCategoryButton();
		
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
		
		assertTrue("Add new category page is not opened", addNewCategoryPage.isOnPage());
		
		addNewCategoryPage.insertName("Darija");
		addNewCategoryPage.insertDescription("Ja sam Darija Antonijevic12345678918191919191919191");
		
		addNewCategoryPage.clickOnCancelButton();
		
		assertTrue("Post categories list page not opened", postCategoriesListPage.isOnPage());
	}
	
	
	//Insert name and description(50 char) and click on save
	@Test
	public void tc08() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		postCategoriesListPage.clickOnAddNewCategoryButton();
			
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
			
		assertTrue("Add new category page is not opened", addNewCategoryPage.isOnPage());
			
		addNewCategoryPage.insertName(categoryName);
		addNewCategoryPage.insertDescription(description);
			
		addNewCategoryPage.clickOnSaveButton();
		
		assertTrue("Post categories list page not opened", postCategoriesListPage.isOnPage());
		assertTrue("Category name missing", postCategoriesListPage.isCategoryNameOnPage(categoryName));
	}
	
	//Insert name and description(50 char) and click on cancel
	@Test
	public void tc09() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		postCategoriesListPage.clickOnAddNewCategoryButton();
			
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
			
		assertTrue("Add new category page is not opened", addNewCategoryPage.isOnPage());
			
		addNewCategoryPage.insertName(categoryName);
		addNewCategoryPage.insertDescription(description);
			
		addNewCategoryPage.clickOnCancelButton();
		
		assertTrue("Post categories list page not opened", postCategoriesListPage.isOnPage());
	}
	
	//Insert already used name and description and click on save
	@Test
	public void tc10() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		postCategoriesListPage.clickOnAddNewCategoryButton();
			
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
			
		assertTrue("Add new category page is not opened", addNewCategoryPage.isOnPage());
		
		addNewCategoryPage.insertName(categoryName);
		addNewCategoryPage.insertDescription(description);
			
		addNewCategoryPage.clickOnSaveButton();
		
		assertTrue("Name is already been taken - message missing", addNewCategoryPage.isNameAlreadyTakenErrorOnPage("The name has already been taken."));
		
		
	}
	
//	//Click on view button
//	@Test
//	public void tc11() {
//		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
//		
//		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));
//		
//		MyWebDriver.scroolToWebElement(driver, element);
//		
//		postCategoriesListPage.clickOnViewButton(categoryName);
//		
//		ViewPostPage viewPostPage = new ViewPostPage(driver);
//		
//		assertTrue("Wrong page opened", viewPostPage.isCategoryNameOnPage(categoryName) );
//
//	Pise opet da ne moze da pronadje element i izlazi mi error
//	}
	
	// Click on view button 2.nacin
	@Test
	public void tc11() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		postCategoriesListPage.clickOnViewButton(categoryName);
		
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		assertTrue("page open problem", driver.getTitle().contains(categoryName));
		
	}//prekucala sam kod, ali nije mi jasno sta sam uradila, i ovako radi
	
	
	// Edit post category, leave fields, click on cancel
	@Test
	public void tc12() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		postCategoriesListPage.clickOnEditButton(categoryName);
		
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
		
		assertTrue("Wrong page opened", categoryName.equalsIgnoreCase(addNewCategoryPage.getName()));
		
		addNewCategoryPage.clickOnCancelButton();
		
		assertTrue("Category list page not open", postCategoriesListPage.isOnPage());

		assertTrue("Category name missing", postCategoriesListPage.isCategoryNameOnPage(categoryName));
		
		
		
	}	
	
	// Edit post category, clear fields, click on cancel
	@Test
	public void tc13() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
			
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));		
		MyWebDriver.scroolToWebElement(driver, element);
			
		postCategoriesListPage.clickOnEditButton(categoryName);
		
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);	
			
		assertTrue("Wrong page opened", categoryName.equalsIgnoreCase(addNewCategoryPage.getName()));
			
		addNewCategoryPage.insertName("");
		addNewCategoryPage.insertDescription("");
			
		addNewCategoryPage.clickOnCancelButton();
			
		assertTrue("Category list page not open", postCategoriesListPage.isOnPage());

		assertTrue("Category name missing", postCategoriesListPage.isCategoryNameOnPage(categoryName));
			
			
		}	
	
	// Edit post category, insert text in fields, click on cancel
	@Test
	public void tc14() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
				
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));		
		MyWebDriver.scroolToWebElement(driver, element);
				
		postCategoriesListPage.clickOnEditButton(categoryName);
			
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);	
				
		assertTrue("Wrong page opened", categoryName.equalsIgnoreCase(addNewCategoryPage.getName()));
				
		addNewCategoryPage.insertName("Tamara");
		addNewCategoryPage.insertDescription("blablnajdahsdhdhhdahashdada");
				
		addNewCategoryPage.clickOnCancelButton();
				
		assertTrue("Category list page not open", postCategoriesListPage.isOnPage());

		assertTrue("Category name missing", postCategoriesListPage.isCategoryNameOnPage(categoryName));
	
		}	
	
	// Edit post category, clear text, click on save
	@Test
	public void tc15() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
					
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));		
		MyWebDriver.scroolToWebElement(driver, element);
				
		postCategoriesListPage.clickOnEditButton(categoryName);
				
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);	
					
		assertTrue("Wrong page opened", categoryName.equalsIgnoreCase(addNewCategoryPage.getName()));
					
		addNewCategoryPage.insertName("");
		addNewCategoryPage.insertDescription("");
					
		addNewCategoryPage.clickOnSaveButton();
					
		assertTrue("Name is required field - error is missing", addNewCategoryPage.isNameErrorOnPage("This field is required."));
		assertTrue("Description is required field - error is missing", addNewCategoryPage.isDescriptionErrorOnPage("This field is required."));
		
	}	
	
	// Edit post category, leave fields, click on save
	@Test
	public void tc16() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
			
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));		
		MyWebDriver.scroolToWebElement(driver, element);
			
		postCategoriesListPage.clickOnEditButton(categoryName);
			
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
			
		assertTrue("Wrong page opened", categoryName.equalsIgnoreCase(addNewCategoryPage.getName()));
			
		addNewCategoryPage.clickOnSaveButton();
			
		assertTrue("Category list page not open", postCategoriesListPage.isOnPage());

		assertTrue("Category name missing", postCategoriesListPage.isCategoryNameOnPage(categoryName));
						
		}	
	
	// Edit post category, leave name, edit description, click on save
	@Test
	public void tc17() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
						
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));		
		MyWebDriver.scroolToWebElement(driver, element);
					
		postCategoriesListPage.clickOnEditButton(categoryName);
					
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);	
						
		assertTrue("Wrong page opened", categoryName.equalsIgnoreCase(addNewCategoryPage.getName()));
						
		addNewCategoryPage.insertDescription(newDescription);
						
		addNewCategoryPage.clickOnSaveButton();
		
		assertTrue("Post categories list page not opened", postCategoriesListPage.isOnPage());
		assertTrue("New description is missing", postCategoriesListPage.isCategoryDescriptionOnPage(newDescription, categoryName));
			
	}	
	
	// Edit post category, clear name, edit description, click on save
	@Test
	public void tc18() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
							
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));		
		MyWebDriver.scroolToWebElement(driver, element);
						
		postCategoriesListPage.clickOnEditButton(categoryName);
						
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);	
							
		assertTrue("Wrong page opened", categoryName.equalsIgnoreCase(addNewCategoryPage.getName()));
				
		addNewCategoryPage.insertName("");							
		addNewCategoryPage.insertDescription(newDescription);
							
		addNewCategoryPage.clickOnSaveButton();
			
		assertTrue("Name is required field - error is missing", addNewCategoryPage.isNameErrorOnPage("This field is required."));

				
	}
	
	// Edit post category, edit name, clear description, click on save
	@Test
	public void tc19() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
							
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));		
		MyWebDriver.scroolToWebElement(driver, element);
						
		postCategoriesListPage.clickOnEditButton(categoryName);
						
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);	
							
		assertTrue("Wrong page opened", categoryName.equalsIgnoreCase(addNewCategoryPage.getName()));
				
		addNewCategoryPage.insertName(newCategoryName);							
		addNewCategoryPage.insertDescription("");
							
		addNewCategoryPage.clickOnSaveButton();
			
		assertTrue("Description is required field - error is missing", addNewCategoryPage.isDescriptionErrorOnPage("This field is required."));

			
	}
	
	// Edit post category, edit name, edit description, click on save
	@Test
	public void tc20() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
								
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+categoryName+"']"));		
		MyWebDriver.scroolToWebElement(driver, element);
							
		postCategoriesListPage.clickOnEditButton(categoryName);
							
		AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);	
								
		assertTrue("Wrong page opened", categoryName.equalsIgnoreCase(addNewCategoryPage.getName()));
				
		addNewCategoryPage.insertName(newCategoryName);							
		addNewCategoryPage.insertDescription(newDescription);
								
		addNewCategoryPage.clickOnSaveButton();
				
		assertTrue("Post categories list page not opened", postCategoriesListPage.isOnPage());
		assertTrue("New name is missing", postCategoriesListPage.isCategoryNameOnPage(newCategoryName));	
		assertTrue("New description is missing", postCategoriesListPage.isCategoryDescriptionOnPage(newDescription, newCategoryName));	
	}
	
	// Click on delete button, click on close dialog button
	@Test
	public void tc21() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
		
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+newCategoryName+"']"));
		MyWebDriver.scroolToWebElement(driver, element);
		
		postCategoriesListPage.clickOnDeleteButton(newCategoryName);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		postCategoriesListPage.clickOnDeleteDialogCloseButton();
		
		assertTrue("Post categories list page not opened", postCategoriesListPage.isOnPage());
		assertTrue("New name is missing", postCategoriesListPage.isCategoryNameOnPage(newCategoryName));	
				
	}
	
	// Click on delete button, click on cancel dialog button
	@Test
	public void tc22() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
			
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+newCategoryName+"']"));
		MyWebDriver.scroolToWebElement(driver, element);
			
		postCategoriesListPage.clickOnDeleteButton(newCategoryName);
			
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		postCategoriesListPage.clickOnDeleteDialogCancelButton();
			
		assertTrue("Post categories list page not opened", postCategoriesListPage.isOnPage());
		assertTrue("New name is missing", postCategoriesListPage.isCategoryNameOnPage(newCategoryName));	
					
	}
	
	// Click on delete button, click on delete dialog button
	@Test
	public void tc23() {
		PostCategoriesListPage postCategoriesListPage = new PostCategoriesListPage(driver);
			
		WebElement element = driver.findElement(By.xpath("//strong[text()='"+newCategoryName+"']"));
		MyWebDriver.scroolToWebElement(driver, element);
		
		postCategoriesListPage.clickOnDeleteButton(newCategoryName);
			
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		postCategoriesListPage.clickOnDeleteDialogDeleteButton();
			
		assertTrue("Post categories list page not opened", postCategoriesListPage.isOnPage());
		assertTrue("Post category name is not deleted", !postCategoriesListPage.isCategoryNameOnPage(newCategoryName));
					
	}
	
}
