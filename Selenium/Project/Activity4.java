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

public class Activity4 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void openbrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		wait = new WebDriverWait(driver, 15);
	    
		}

	@Test
	public void verifytitle() throws InterruptedException {
		String Expected = driver.findElement(By.xpath("//*[starts-with(@id,'post')]/div[2]/h3[contains(text(),'Email')]")).getText();
		String Actual = "Email Marketing Strategies";
		Assert.assertEquals(Actual, Expected);
		System.out.println("Training heading is: "+Expected);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closebrowser() {
	driver.quit();	
    }
	
}
