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

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void openbrowser() {
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		wait = new WebDriverWait(driver, 15);
	    
		}

	@Test
	public void verifycourses() throws InterruptedException {
		WebElement allcourse  = driver.findElement(By.linkText("All Courses"));
		allcourse.click();
		
		List<WebElement> listwebelement = driver.findElements(By.xpath("//*[@class='ld_course_grid col-sm-8 col-md-4 ']//h3"));
		System.out.println(listwebelement.size());
		int i=0;
		for (WebElement Element : listwebelement) {
            i = i+1;
            System.out.println(Element.getTagName());
            System.out.println(Element.getText());

            
        }
        System.out.println("total courses found " + i);

		Thread.sleep(3000);
    }
		
		
	
	
	@AfterMethod
	public void closebrowser() {
	driver.quit();	
    }
	
}
