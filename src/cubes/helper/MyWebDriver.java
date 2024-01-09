package cubes.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyWebDriver {

	public static WebDriver getDriver(String browser) {
		

		WebDriver webDriver;
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darija\\Desktop\\webdriver\\chromedriver.exe");
			webDriver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darija\\Desktop\\webdriver\\chromedriver.exe");
			webDriver = new ChromeDriver();
		}

		else {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Darija\\Desktop\\webdriver\\chromedriver.exe");
			webDriver = new ChromeDriver();

		}

		webDriver.manage().window().maximize();

		return webDriver;

	}
	
	//metoda koja skroluje do elementa
	public static void scroolToWebElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

}
