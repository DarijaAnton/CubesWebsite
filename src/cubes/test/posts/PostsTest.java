package cubes.test.posts;

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
import cubes.pages.posts.AddNewPostPage;
import cubes.pages.posts.PostsListPage;
import io.opentelemetry.api.internal.Utils;

public class PostsTest {
	
	private static WebDriver driver;
	
	
	//TITLE
	private String titleName = "Darija Antonijevic ima 25 godina";
	
	
	//SLIKE
	private String malaSlika = "C:\\Users\\Darija\\Desktop\\workspace\\zavrsni_projekat\\Images\\mala.jpg";
	private String velikaSlika = "C:\\Users\\Darija\\Desktop\\workspace\\zavrsni_projekat\\Images\\velika.jpg";
	
	
	//CONTENT
	private String contentLabel = "//label[text()='Content']";
	private String iFrameLocator = "//iframe[@class='cke_wysiwyg_frame cke_reset']";
	private String contentLocator = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']";
	

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

	
	//Add new post - all fields empty
	@Test
	public void tc01() {
		
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("-- Choose Category --");
		addNewPostPage.insertTitle("");
		addNewPostPage.insertDescription("");
		addNewPostPage.selectRadioButton();
		addNewPostPage.chooseTag("Vuk");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		//WebElement element = driver.findElement(By.xpath("//input[@name='photo']"));		
		//MyWebDriver.scroolToWebElement(driver, element);
		//addNewPostPage.uploadPhoto(malaSlika);
		
		//try {
		//	Thread.sleep(5000);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		//String contentLabel = driver.findElement(By.xpath(contentLabel));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		addNewPostPage.clickOnCancelButton();
		
		assertTrue("Posts list page is not opened", postsListPage.isOnPage());
		
		
	}
	
	@Test
	public void tc02(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("-- Choose Category --");
		addNewPostPage.insertTitle("");
		addNewPostPage.insertDescription("");
		addNewPostPage.selectRadioButton();
		addNewPostPage.chooseTag("Vuk");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		addNewPostPage.clickOnSaveButton();
		
		assertTrue("Title error is not displayed", addNewPostPage.isTitleErrorOnPage("This field is required."));
		assertTrue("Description error is not displayed", addNewPostPage.isDescriptionErrorOnPage("This field is required."));
		assertTrue("Tag error is not displayed", addNewPostPage.isTagErrorOnPage("This field is required."));
	}
	
	
	
	
	@Test
	public void tc03(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("");
		addNewPostPage.insertDescription("");
		addNewPostPage.selectRadioButton();
		addNewPostPage.chooseTag("Vuk");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		addNewPostPage.clickOnCancelButton();
		
		assertTrue("Wrong page is opened", postsListPage.isOnPage());
		
	}	

	
	@Test
	public void tc04(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("");
		addNewPostPage.insertDescription("");
		addNewPostPage.selectRadioButton();
		addNewPostPage.chooseTag("Vuk");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		addNewPostPage.clickOnSaveButton();
		
		assertTrue("Title error is not displayed", addNewPostPage.isTitleErrorOnPage("This field is required."));
		assertTrue("Description error is not displayed", addNewPostPage.isDescriptionErrorOnPage("This field is required."));
		assertTrue("Tag error is not displayed", addNewPostPage.isTagErrorOnPage("This field is required."));
	}
	
	@Test
	public void tc05(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija");
		addNewPostPage.insertDescription("");
		addNewPostPage.selectRadioButton();
		addNewPostPage.chooseTag("Vuk");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		addNewPostPage.clickOnCancelButton();
		
		assertTrue("Wrong page is opened", postsListPage.isOnPage());
		
	}	
	
	
	
	@Test
	public void tc06(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija");
		addNewPostPage.insertDescription("");
		addNewPostPage.selectRadioButton();
		//addNewPostPage.chooseTag();
		
		//try {
		//	Thread.sleep(3000);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		addNewPostPage.clickOnSaveButton();
		
		
		assertTrue("Title error is not displayed", addNewPostPage.isTitleErrorOnPage("Please enter at least 20 characters."));
		assertTrue("Description error is not displayed", addNewPostPage.isDescriptionErrorOnPage("This field is required."));
		assertTrue("Tag error is not displayed", addNewPostPage.isTagErrorOnPage("This field is required."));
	}
	
	
	@Test
	public void tc07(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija Antonijevic ima 25 godina");
		addNewPostPage.insertDescription("");
		addNewPostPage.selectRadioButton();
		//addNewPostPage.chooseTag();
		
		//try {
		//	Thread.sleep(3000);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		addNewPostPage.clickOnSaveButton();
		
		//assertTrue("Title error is not displayed", addNewPostPage.isTitleErrorOnPage("Please enter at least 20 characters."));
		assertTrue("Description error is not displayed", addNewPostPage.isDescriptionErrorOnPage("This field is required."));
		assertTrue("Tag error is not displayed", addNewPostPage.isTagErrorOnPage("This field is required."));
	}
	
	
	@Test
	public void tc08(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija Antonijevic ima 25 godina");
		addNewPostPage.insertDescription("Ja");
		addNewPostPage.selectRadioButton();
		//addNewPostPage.chooseTag();
		
		//try {
		//	Thread.sleep(3000);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		addNewPostPage.clickOnCancelButton();
		
		assertTrue("Wrong page opened", postsListPage.isOnPage());
	}
	
	//Add new post - enter description, click on save
	@Test
	public void tc09(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija Antonijevic ima 25 godina");
		addNewPostPage.insertDescription("Ja");
		addNewPostPage.selectRadioButton();
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		
		addNewPostPage.clickOnSaveButton();
		
		//assertTrue("Title error is not displayed", addNewPostPage.isTitleErrorOnPage("Please enter at least 20 characters."));
		assertTrue("Description error is not displayed", addNewPostPage.isDescriptionErrorOnPage("Please enter at least 50 characters."));
		assertTrue("Tag error is not displayed", addNewPostPage.isTagErrorOnPage("This field is required."));
		
		
	}
	
	
	//Add new post - enter description, click on save
	@Test
	public void tc10(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija Antonijevic ima 25 godina");
		addNewPostPage.insertDescription("Ja sam Darija Antonijevic i zivim na Novom Beogradu.");
		addNewPostPage.selectRadioButton();
		//addNewPostPage.chooseTag();
		
		//try {
		//	Thread.sleep(3000);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		
		addNewPostPage.clickOnSaveButton();
		
		//assertTrue("Title error is not displayed", addNewPostPage.isTitleErrorOnPage("Please enter at least 20 characters."));
		//assertTrue("Description error is not displayed", addNewPostPage.isDescriptionErrorOnPage("Please enter at least 50 characters."));
		assertTrue("Tag error is not displayed", addNewPostPage.isTagErrorOnPage("This field is required."));
		
		
	}	
	
	
	//Add new post - choose one tag, click on cancel
	@Test
	public void tc11(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija Antonijevic ima 25 godina");
		addNewPostPage.insertDescription("Ja sam Darija Antonijevic i zivim na Novom Beogradu.");
		addNewPostPage.selectRadioButton();
		addNewPostPage.chooseTag("Vuk");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		
		addNewPostPage.clickOnCancelButton();
		
		//assertTrue("Title error is not displayed", addNewPostPage.isTitleErrorOnPage("Please enter at least 20 characters."));
		//assertTrue("Description error is not displayed", addNewPostPage.isDescriptionErrorOnPage("Please enter at least 50 characters."));
		//assertTrue("Tag error is not displayed", addNewPostPage.isTagErrorOnPage("This field is required."));
		
		assertTrue("Wrong page opened", postsListPage.isOnPage());
		
		
	}	
	
	//Add new post - choose one tag, click on save
	@Test
	public void tc12(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija Antonijevic ima 25 godina");
		addNewPostPage.insertDescription("Ja sam Darija Antonijevic i zivim na Novom Beogradu.");
		addNewPostPage.selectRadioButton();
		addNewPostPage.chooseTag("Vuk");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		
		addNewPostPage.clickOnSaveButton();
		
		//assertTrue("Title error is not displayed", addNewPostPage.isTitleErrorOnPage("Please enter at least 20 characters."));
		//assertTrue("Description error is not displayed", addNewPostPage.isDescriptionErrorOnPage("Please enter at least 50 characters."));
		//assertTrue("Tag error is not displayed", addNewPostPage.isTagErrorOnPage("This field is required."));
		assertTrue("Content error is not displayed", addNewPostPage.isContentErrorOnPage("The content field is required."));
		
		//assertTrue("Wrong page opened", postsListPage.isOnPage());
		
		
	}		
	
	//Add new post - insert image, click on save
	@Test
	public void tc13(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija Antonijevic ima 25 godina");
		addNewPostPage.insertDescription("Ja sam Darija Antonijevic i zivim na Novom Beogradu.");
		addNewPostPage.selectRadioButton();
		addNewPostPage.chooseTag("Vuk");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement element = driver.findElement(By.xpath("//input[@name='photo']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		addNewPostPage.uploadPhoto(malaSlika);
				
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element2 = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element2);
		
		
		addNewPostPage.clickOnSaveButton();
		
		//assertTrue("Title error is not displayed", addNewPostPage.isTitleErrorOnPage("Please enter at least 20 characters."));
		//assertTrue("Description error is not displayed", addNewPostPage.isDescriptionErrorOnPage("Please enter at least 50 characters."));
		//assertTrue("Tag error is not displayed", addNewPostPage.isTagErrorOnPage("This field is required."));
		assertTrue("Content error is not displayed", addNewPostPage.isContentErrorOnPage("The content field is required."));
		
		//assertTrue("Wrong page opened", postsListPage.isOnPage());
		
		
	}			
	
	//Add new post - insert image - velika slika
	@Test
	public void tc14(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija Antonijevic ima 25 godina");
		addNewPostPage.insertDescription("Ja sam Darija Antonijevic i zivim na Novom Beogradu.");
		addNewPostPage.selectRadioButton();
		addNewPostPage.chooseTag("Vuk");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement element = driver.findElement(By.xpath("//input[@name='photo']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		addNewPostPage.uploadPhoto(velikaSlika);
				
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "");
		
		
		WebElement element2 = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element2);
		
		
		addNewPostPage.clickOnSaveButton();
		
		//assertTrue("Title error is not displayed", addNewPostPage.isTitleErrorOnPage("Please enter at least 20 characters."));
		//assertTrue("Description error is not displayed", addNewPostPage.isDescriptionErrorOnPage("Please enter at least 50 characters."));
		//assertTrue("Tag error is not displayed", addNewPostPage.isTagErrorOnPage("This field is required."));
		assertTrue("Content error is not displayed", addNewPostPage.isContentErrorOnPage("The content field is required."));
		
		//assertTrue("Wrong page opened", postsListPage.isOnPage());
		
		
	}				
	
	
	//Add new post - Enter content
	@Test
	public void tc15(){
		PostsListPage postsListPage = new PostsListPage(driver);
		postsListPage.clickOnAddNewPostButton();
		
		AddNewPostPage addNewPostPage = new AddNewPostPage(driver);
		assertTrue("Add new post page is not opened", addNewPostPage.isOnPage());
		
		addNewPostPage.chooseCategory("Ivona");
		addNewPostPage.insertTitle("Darija Antonijevic ima 25 godina");
		addNewPostPage.insertDescription("Ja sam Darija Antonijevic i zivim na Novom Beogradu.");
		addNewPostPage.selectRadioButton();
		addNewPostPage.chooseTag("Vuk");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement element = driver.findElement(By.xpath("//input[@name='photo']"));		
		MyWebDriver.scroolToWebElement(driver, element);
		addNewPostPage.uploadPhoto(malaSlika);
				
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement contentLabel = driver.findElement(By.xpath("//label[text()='Content']"));
		MyWebDriver.scroolToWebElement(driver, contentLabel);
		
		addNewPostPage.insertContent(iFrameLocator, contentLocator, "hahaha");
		
		
		WebElement element2 = driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']"));		
		MyWebDriver.scroolToWebElement(driver, element2);
		
		
		addNewPostPage.clickOnSaveButton();
		
		assertTrue("Wrong page opened", postsListPage.isOnPage());
		
		WebElement element3 = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));		
		MyWebDriver.scroolToWebElement(driver, element3);
		
		postsListPage.searchTitle("Darija Antonijevic ima 25 godina");
		
		
		assertTrue("Title is not on page", postsListPage.isTitleOnPage("Darija Antonijevic ima 25 godina"));
		
	
		
		
	}		
	
	
	//Click on view Button
		@Test
		public void tc16(){
		PostsListPage postsListPage = new PostsListPage(driver);
		
		WebElement element3 = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));		
		MyWebDriver.scroolToWebElement(driver, element3);
		
		postsListPage.searchTitle("Darija Antonijevic ima 25 godina");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement element = driver.findElement(By.xpath("//td[text()='"+ titleName +"']//ancestor::tr/td[12]/div[1]/a[1]"));		
		MyWebDriver.scroolToWebElement(driver, element);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		postsListPage.clickOnViewButton(titleName);
		
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		assertTrue("page open problem", driver.getTitle().contains(titleName));
		
		}
		
	//DISABLE BUTTON, IN POP UP CLICK ON CANCEL
		@Test
		public void tc17() {
			PostsListPage postListPage = new PostsListPage(driver);
			
			WebElement element3 = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));		
			MyWebDriver.scroolToWebElement(driver, element3);
			
			postListPage.searchTitle("Darija Antonijevic ima 25 godina");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			WebElement element = driver.findElement(By.xpath("//td[text()='"+titleName+"']//ancestor::tr/td[12]/div[2]/button[1]"));		
			MyWebDriver.scroolToWebElement(driver, element);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			postListPage.clickOnDisableButton(titleName);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			postListPage.clickOnDisableDialogCancelButton();
			
			assertTrue("Posts list page not opened", postListPage.isOnPage());
			assertTrue("Title name is missing", postListPage.isTitleOnPage(titleName));	

			
		}
		
		//DISABLE BUTTON, IN POP UP CLICK ON DISABLE
		@Test
		public void tc18() {
			PostsListPage postListPage = new PostsListPage(driver);
			
			WebElement element3 = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));		
			MyWebDriver.scroolToWebElement(driver, element3);
			
			postListPage.searchTitle("Darija Antonijevic ima 25 godina");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			WebElement element = driver.findElement(By.xpath("//td[text()='"+titleName+"']//ancestor::tr/td[12]/div[2]/button[1]"));		
			MyWebDriver.scroolToWebElement(driver, element);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			postListPage.clickOnDisableButton(titleName);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			postListPage.clickOnDisableDialogButton();
			
			assertTrue("Posts list page not opened", postListPage.isOnPage());
			assertTrue("Title name is missing", postListPage.isTitleOnPage(titleName));	

			
		}
		
		
		//CLICK ON ENABLE BUTTON
		@Test
		public void tc19() {
			PostsListPage postListPage = new PostsListPage(driver);
			
			WebElement element3 = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));		
			MyWebDriver.scroolToWebElement(driver, element3);
			
			postListPage.searchTitle("Darija Antonijevic ima 25 godina");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			WebElement element = driver.findElement(By.xpath("//td[text()='"+titleName+"']//ancestor::tr/td[12]/div[2]/button[1]"));		
			MyWebDriver.scroolToWebElement(driver, element);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			postListPage.clickOnEnableButton(titleName);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			postListPage.clickOnEnableDialogButton();
			
			assertTrue("Posts list page not opened", postListPage.isOnPage());
			assertTrue("Title name is missing", postListPage.isTitleOnPage(titleName));	

			
		}
		
		@Test
		public void tc20() {
			PostsListPage postListPage = new PostsListPage(driver);
			
			WebElement element3 = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));		
			MyWebDriver.scroolToWebElement(driver, element3);
			
			postListPage.searchTitle("Darija Antonijevic ima 25 godina");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			WebElement element = driver.findElement(By.xpath("//td[text()='"+titleName+"']//ancestor::tr/td[12]/div[2]/button[2]"));		
			MyWebDriver.scroolToWebElement(driver, element);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			postListPage.setAsUnimportant(titleName);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			postListPage.setAsUnimportantDialogButton();
			
			assertTrue("Posts list page not opened", postListPage.isOnPage());
			assertTrue("Title name is missing", postListPage.isTitleOnPage(titleName));	

			
		}
	
}
