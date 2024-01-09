package cubes.test;

import static org.junit.Assert.*;

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

public class LoginTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		driver = MyWebDriver.getDriver("chrome");

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

	// Login with empty fields
	@Test
	public void tc01() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("");
		loginPage.insertPassword("");
		loginPage.clickOnLogin();
		
		//loginPage.login("", ""); jos jedan nacin da isto kao ovo gore samo sa koriscenjem metode
		
		//emailElement.sendKeys("");
		//passwordElement.sendKeys("");
		//loginElement.click();

		assertTrue("Email is required - message is missing",loginPage.checkEmailError("Email* is required field"));
		assertTrue("Password is required - message is missing",loginPage.checkPasswordError("Password* is required field"));
	}

	// Login with incorrect Email format
	@Test
	public void tc02() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("abc123");
		loginPage.insertPassword("");
		loginPage.clickOnLogin();
		
		//emailElement.sendKeys("abc123");
		//passwordElement.sendKeys("");
		//loginElement.click();
		
		assertTrue("Enter valid email  - message is missing",loginPage.checkEmailError("Please, enter the valid Email address"));
		assertTrue("Password is required - message is missing",loginPage.checkPasswordError("Password* is required field"));

	}

	// Login with invalid Email
	@Test
	public void tc03() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("example@mail123.com");
		loginPage.insertPassword("");
		loginPage.clickOnLogin();
		
		//emailElement.sendKeys("example@mail123.com");
		//passwordElement.sendKeys("");
		//loginElement.click();
		
		assertTrue("Password is required - message is missing",loginPage.checkPasswordError("Password* is required field"));

		//WebElement passwordErrorElement = driver.findElement(By.id("password-error"));
		//assertTrue("Password is required - message is missing",passwordErrorElement.getText().equalsIgnoreCase("Password* is required field"));
	}

	// Login with valid Email
	@Test
	public void tc04() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("kurs@cubes.edu.rs");
		loginPage.insertPassword("");
		loginPage.clickOnLogin();
		
		
		//emailElement.sendKeys("kursqa@cubes.edu.rs");
		//passwordElement.sendKeys("");
		//loginElement.click();
		
		assertTrue("Password is required - message is missing",loginPage.checkPasswordError("Password* is required field"));

	}

	// Try to login with empty Email address and incorrect password
	@Test
	public void tc05() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("");
		loginPage.insertPassword("abcabc");
		loginPage.clickOnLogin();
		
		//emailElement.sendKeys("");
		//passwordElement.sendKeys("abcabc");
		//loginElement.click();

		assertTrue("Email is required - message is missing",loginPage.checkEmailError("Email* is required field"));
	}

	// Login with empty Email field and valid password
	@Test
	public void tc06() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnLogin();
		
		//emailElement.sendKeys("");
		//passwordElement.sendKeys("ValidPassword");
		//loginElement.click();
		
		assertTrue("Email is required - message is missing",loginPage.checkEmailError("Email* is required field"));


	}

	// Login with incorrect Email format and invalid Password
	@Test
	public void tc07() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("abc123");
		loginPage.insertPassword("abcabc");
		loginPage.clickOnLogin();
		
		//emailElement.sendKeys("abc123");
		//passwordElement.sendKeys("abcabc");
		//loginElement.click();
		
		assertTrue("Enter valid email  - message is missing",loginPage.checkEmailError("Please, enter the valid Email address"));

	
	}

	// Login with invalid Email address and invalid Password
	@Test
	public void tc08() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("example@mail123.com");
		loginPage.insertPassword("abcabc");
		loginPage.clickOnLogin();
		
		//emailElement.sendKeys("example@mail123.com");
		//passwordElement.sendKeys("abcabc");
		//loginElement.click();
		
		assertTrue("Email error message is missing",loginPage.checkEmailError("These credentials do not match our records."));

	}

	// Login with valid Email address and invalid Password
	@Test
	public void tc09() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("kursqa@cubes.edu.rs");
		loginPage.insertPassword("abcabc");
		loginPage.clickOnLogin();
		
		//emailElement.sendKeys("kursqa@cubes.edu.rs");
		//passwordElement.sendKeys("abcabc");
		//loginElement.click();
		
		assertTrue("Email error message is missing",loginPage.checkEmailError("These credentials do not match our records."));

	}

	// Login with incorrect Email address and valid Password
	@Test
	public void tc10() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("abc123");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnLogin();
		
		//emailElement.sendKeys("abc123");
		//passwordElement.sendKeys("ValidPassword");
		//loginElement.click();
		
		assertTrue("Enter valid email  - message is missing",loginPage.checkEmailError("Please, enter the valid Email address"));
	
	}

	// Login with invalid Email address and valid Password
	@Test
	public void tc11() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.insertEmail("example@mail123.com");
		loginPage.insertPassword("cubesqa");
		loginPage.clickOnLogin();
		
		
		//emailElement.sendKeys("example@mail123.com");
		//passwordElement.sendKeys("ValidPassword");
		//loginElement.click();
		
		assertTrue("Email error message is missing",loginPage.checkEmailError("These credentials do not match our records."));
	}

	// Login with valid Email address and valid Password
	@Test
	public void tc12() {
		LoginPage loginPage = new LoginPage(driver);
		
		//loginPage.insertEmail("kursqa@cubes.edu.rs");
		//loginPage.insertPassword("cubesqa");
		//loginPage.clickOnLogin();
		
		loginPage.loginSuccess();

	}

}
