package cubes.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;
import cubes.pages.tag.TagsAddPage;
import cubes.pages.tag.TagsListPage;

public class TagTest {

	private static WebDriver driver;
	private String tagName = "Tag name 123";
	private String editTagName = "Tag name 12";

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

	//Test koji pokazuje kako radi skrol element
	@Test
	public void tc00() {
		
		TagsListPage tagsListPage = new TagsListPage(driver); 
		
		WebElement element = driver.findElement(By.xpath("//strong[text()='Tag name marko']"));
		
		MyWebDriver.scroolToWebElement(driver, element);
		
		tagsListPage.clickOnEdit("Tag name marko");
		
		TagsAddPage tagsAddPage = new TagsAddPage(driver);
		
		tagsAddPage.clickOnCancel();
	}
	
	// Insert empty tag name and click save
	@Test
	public void tc01() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnAddNewTag();

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Tags add name page is not open", tagsAddPage.isOnPage());

		tagsAddPage.insertName("");

		tagsAddPage.clickOnSave();

		assertTrue("This field is requred - insert tag name error",
				tagsAddPage.isErrorOnPage("This field is required."));
	}

	// Insert empty tag name and click on cancel
	@Test
	public void tc02() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnAddNewTag();

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Tags add name page is not open", tagsAddPage.isOnPage());

		tagsAddPage.insertName("");

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list page not open", tagsListPage.isOnPage());

	}

	// Insert tag name and click cancel
	@Test
	public void tc03() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnAddNewTag();

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Tags add name page is not open", tagsAddPage.isOnPage());

		tagsAddPage.insertName("Test tag name");

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list page not open", tagsListPage.isOnPage());

	}

	// Insert test tag name and click save
	@Test
	public void tc04() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnAddNewTag();

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Tags add name page is not open", tagsAddPage.isOnPage());

		tagsAddPage.insertName(tagName);

		tagsAddPage.clickOnSave();

		assertTrue("Tags list page not open", tagsListPage.isOnPage());

		assertTrue("New tag name missing", tagsListPage.isTagNameElementOnPage(tagName));

	}

	// Insert existing tag name and click save
	@Test
	public void tc05() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnAddNewTag();

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Tags add name page is not open", tagsAddPage.isOnPage());

		tagsAddPage.insertName(tagName);

		tagsAddPage.clickOnSave();

		assertTrue("Tags add page - problem", tagsAddPage.isOnPage());

		assertTrue("Name has already taken - message error",
				tagsAddPage.isNameAlreadyTakenErrorOnPage("The name has already been taken."));
	}

	// Edit tag name, leave text, click on cancel
	@Test
	public void tc06() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnEdit(tagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element ", tagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list page not open", tagsListPage.isOnPage());

		assertTrue("New tag name missing", tagsListPage.isTagNameElementOnPage(tagName));

	}

	// Edit tag name, clear text, click on cancel
	@Test
	public void tc07() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnEdit(tagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element ", tagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.insertName("");

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list page not open", tagsListPage.isOnPage());

		assertTrue("New tag name missing", tagsListPage.isTagNameElementOnPage(tagName));
	}

	// Edit tag name, insert text, click on cancel
	@Test
	public void tc08() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnEdit(tagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element ", tagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.insertName("Darija123");

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list page not open", tagsListPage.isOnPage());

		assertTrue("New tag name missing", tagsListPage.isTagNameElementOnPage(tagName));
	}

	// Edit tag name, clear text, click on save
	@Test
	public void tc09() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnEdit(tagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element ", tagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.insertName("");

		tagsAddPage.clickOnSave();

		assertTrue("This field is requred - insert tag name error",tagsAddPage.isErrorOnPage("This field is required."));

	}

	// Edit tag name, leave text, click on save
	@Test
	public void tc10() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnEdit(tagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element ", tagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.clickOnSave();

		assertTrue("Tags list page not open", tagsListPage.isOnPage());

		assertTrue("New tag name missing", tagsListPage.isTagNameElementOnPage(tagName));
	}
	
	// Edit tag name, edit text, click on save
	@Test
	public void tc11() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnEdit(tagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element ", tagName.equalsIgnoreCase(tagsAddPage.getName()));
		
		tagsAddPage.insertName(editTagName);

		tagsAddPage.clickOnSave();

		assertTrue("Tags list page not open", tagsListPage.isOnPage());

		assertTrue("New tag name missing", tagsListPage.isTagNameElementOnPage(editTagName));
	}
	
	
	//Delete tag and click on cancel
	@Test
	public void tc12() {
		TagsListPage tagsListPage = new TagsListPage(driver);
		
		tagsListPage.clickOnDelete(editTagName);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
	
		}
		
		tagsListPage.clickOnDeleteDialogCancelButton();
		
		assertTrue("Tags list page not open", tagsListPage.isOnPage());
		
		assertTrue("New tag name missing", tagsListPage.isTagNameElementOnPage(editTagName));
	}
	
	//Delete tag and click on close
	@Test
	public void tc13() {
		TagsListPage tagsListPage = new TagsListPage(driver);
		
		tagsListPage.clickOnDelete(editTagName);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
	
		}
		
		tagsListPage.clickOnDeleteDialogCloseButton();
		
		assertTrue("Tags list page not open", tagsListPage.isOnPage());
		
		assertTrue("New tag name missing", tagsListPage.isTagNameElementOnPage(editTagName));
	}
	
	
	//Delete tag and click on delete 
	@Test
	public void tc14() {
		TagsListPage tagsListPage = new TagsListPage(driver);
		
		tagsListPage.clickOnDelete(editTagName);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
	
		}
		
		tagsListPage.clickOnDeleteDialogDeleteButton();
		
		assertTrue("Tags list page not open", tagsListPage.isOnPage());
		
		assertTrue("Tag element is not deleted", !tagsListPage.isTagNameElementOnPage(editTagName));
	}
	
	// Edit tag name, leave text, click on cancel
	@Test
	public void tc15() {
		TagsListPage tagsListPage = new TagsListPage(driver);

		tagsListPage.clickOnEdit(tagName);

		TagsAddPage tagsAddPage = new TagsAddPage(driver);

		assertTrue("Wrong text name in web element ", tagName.equalsIgnoreCase(tagsAddPage.getName()));

		tagsAddPage.clickOnCancel();

		assertTrue("Tags list page not open", tagsListPage.isOnPage());

		assertTrue("New tag name missing", tagsListPage.isTagNameElementOnPage(tagName));

		}

}
