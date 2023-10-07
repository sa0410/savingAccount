package assignment2;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ndeposit {
	WebDriver driver;
	// Element List using By
	By USERNAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGNIN_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By TRANSECTION_FIELD = By.xpath("//span[text()='Transactions']");
	By NEWDEPOSIT_FIELD = By.xpath("//a[text()='New Deposit']");
	By CHOOSEACCOUNT_FIELD = By.xpath("//span[text()='Choose an Account']");
	By SAVINGACCOUNT_FIELD = By.xpath("//li[text()='Saving Account']");
	By DESCRIPTION_FIELD = By.xpath("//input[@id='description']");
	By AMOUNT_FIELD = By.xpath("//input[@id='amount']");
	By SUBMIT_FIELD = By.xpath("//button[@id='submit']");

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	 @After
	public void chromeClose() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

	@Test
	public void loginTest() throws InterruptedException {
		// How do we create variable? >> dataType name = value

		driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_FIELD).click();

		Thread.sleep(3000);
		driver.findElement(TRANSECTION_FIELD).click();
		driver.findElement(NEWDEPOSIT_FIELD).click();

		Thread.sleep(3000);
		driver.findElement(CHOOSEACCOUNT_FIELD).click();
		driver.findElement(SAVINGACCOUNT_FIELD).click();
		driver.findElement(DESCRIPTION_FIELD).sendKeys("sabbir send TF-1");
		driver.findElement(AMOUNT_FIELD).sendKeys("$1225.00");
		driver.findElement(SUBMIT_FIELD).click();

	}

}
