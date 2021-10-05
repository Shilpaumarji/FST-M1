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

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void openbrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		wait = new WebDriverWait(driver, 15);
	    
		}

	@Test
	public void verifylogin() throws InterruptedException {
		driver.findElement(By.linkText("My Account")).click();
		String Expected = driver.getTitle();
		String Actual = "My Account – Alchemy LMS";
		Assert.assertEquals(Actual, Expected);
		System.out.println("You are on My account page-title is : "+Expected);
		//login id-//*[@id="uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91"]//following-sibling::div[2]/a
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("root");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("pa$$w0rd");
		WebElement Login = driver.findElement(By.id("wp-submit"));
		Login.click();
		WebElement loggedinuser = driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a"));
		
		Assert.assertTrue(loggedinuser.isDisplayed());
		System.out.println("Logged in username is displayed: "+loggedinuser.getText());
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void closebrowser() {
	driver.quit();	
    }
	
}
