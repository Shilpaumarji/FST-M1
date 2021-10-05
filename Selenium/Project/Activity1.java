package automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;
	
	@BeforeMethod
	public void openbrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
	    
		}

	@Test
	public void verifytitle() throws InterruptedException {
		
		String Expected = driver.getTitle();
		String Actual = "Alchemy LMS – An LMS Application";
		Assert.assertEquals(Actual, Expected);
		System.out.println(Expected);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closebrowser() {
	driver.quit();	
    }
	
}
