package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	private WebDriver driver;

	@BeforeMethod
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");	
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterSuite() {
		//Đóng driver sau khi test kết thúc
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
