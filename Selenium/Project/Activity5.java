package automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void openbrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		wait = new WebDriverWait(driver, 15);
	    
		}

	@Test
	public void verifyheading() throws InterruptedException {
		driver.findElement(By.linkText("My Account")).click();
		String Expected = driver.getTitle();
		String Actual = "My Account – Alchemy LMS";
		Assert.assertEquals(Actual, Expected);
		System.out.println("You are on My account page-title is : "+Expected);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closebrowser() {
	driver.quit();	
    }
	
}
