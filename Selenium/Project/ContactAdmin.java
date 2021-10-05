package automationframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactAdmin {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void openbrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		wait = new WebDriverWait(driver, 15);
	    
		}

	@Test
	public void verifycontactus() throws InterruptedException {
		WebElement contactus  = driver.findElement(By.linkText("Contact"));
		contactus.click();
		WebElement fullname = driver.findElement(By.xpath("//*[contains(text(),'Full Name ')]//following-sibling::input"));
		fullname.sendKeys("Shilpa");
		WebElement email = driver.findElement(By.xpath("//*[contains(text(),'Email')]//following-sibling::input"));
		email.sendKeys("test5678@gmail.com");
		WebElement subject = driver.findElement(By.xpath("//*[contains(text(),'Subject')]//following-sibling::input"));
		subject.sendKeys("marketing course");
		WebElement text = driver.findElement(By.xpath("//*[contains(text(),'Comment or Message ')]//following-sibling::textarea"));
		text.sendKeys("Facing Issues while taking course");
		driver.findElement(By.name("wpforms[submit]")).click();
		String message = driver.findElement(By.xpath("//div/p[contains(text(),'contacting us!')]")).getText();
	    System.out.println("The message displayed is : "+message);

		Thread.sleep(3000);
    }
		
		
	
	
	@AfterMethod
	public void closebrowser() {
	driver.quit();	
    }
	
}
