package automationframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompleteSimpleLesson {
	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeClass
	public void openbrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		wait = new WebDriverWait(driver, 15);
	    
		}
	@Test (priority = 1)
	public void verifylogin() throws InterruptedException {
		driver.findElement(By.linkText("My Account")).click();
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
	

	@Test (priority = 2)
	public void completelesson() throws InterruptedException {
		WebElement allcourse  = driver.findElement(By.linkText("All Courses"));
		allcourse.click();
		driver.findElement(By.xpath("//*[@id='post-71']/a/img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[starts-with(@id,'ld-expand')]/div/a/div[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'Next Lesson')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='ld-content-action']/form/input[4]")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("You have completed the course: "+title);
		Thread.sleep(3000);
    }
		
		
	
	
	@AfterClass
	public void closebrowser() {
	driver.quit();	
    }
	
}
