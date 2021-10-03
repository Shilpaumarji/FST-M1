package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestSteps {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User is on Login Page$")
    public void LoginPage() throws Throwable {
      
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
       
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    
    @When("^User enters username and password$")
    public void entercredentials() {
    	 WebElement username = driver.findElement(By.id("username"));
	     WebElement password = driver.findElement(By.id("password"));
	     username.sendKeys("admin");
	     password.sendKeys("password");
	     driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("^Read the page title and confirmation message$")
    public void verifymessage() throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
    	String title = driver.getTitle();
    	String confirmMsg = driver.findElement(By.id("action-confirmation")).getText();
    	System.out.println("Page title is : "+title);
    	System.out.println("Confirmation message is : "+confirmMsg);
    	Thread.sleep(3000);
    }
    
    @And("^Close The Browser$")
    public void closebrowser() {
    	driver.quit();
    	
    }
}
