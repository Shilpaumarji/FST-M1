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

public class Activity2 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void openbrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		wait = new WebDriverWait(driver, 10);
	    
		}

	@Test
	public void verifyheading() throws InterruptedException {
		String Expected = driver.findElement(By.xpath("//*[contains(text(),'Learn from Industry Experts')]")).getText();
		String Actual = "Learn from Industry Experts";
		Assert.assertEquals(Actual, Expected);
		System.out.println("Webpage heading is: "+Expected);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closebrowser1() {
	driver.quit();	
    }
	
}
