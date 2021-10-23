package MobileTesting;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {
	 WebDriverWait wait;
	 AppiumDriver<MobileElement> driver = null;
 
  @BeforeClass
  public void setup() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "PixelEmulator");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("appPackage", "com.google.android.keep");
      caps.setCapability("appActivity", ".activities.BrowseActivity");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 10);
      
      System.out.println("Open google Keep");
      Thread.sleep(8000);
	  
      
	  
  }

  @Test
  public void addnotes() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  System.out.println("Google Keep is open");
      Thread.sleep(2000);
      //create new note
      MobileElement addnote1 = driver.findElementById("new_note_button");
      
      addnote1.click();
      Thread.sleep(2000);
      MobileElement addtitle1 = driver.findElementById("editable_title");
      addtitle1.sendKeys("complete Assignments");
      Thread.sleep(2000);
      MobileElement addnotes1 = driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'edit_note_text')]");
      addnotes1.sendKeys("complete appium project activities");
      Thread.sleep(2000);
      //MobileElement addbutton1 = driver.findElementByAccessibilityId("Add");
      //addbutton1.click();
      Thread.sleep(2000);
      MobileElement backbtn = driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']");
      backbtn.click();
      
      String expected = driver.findElementByXPath("//android.widget.TextView[contains(@resource-id,'index_note_title')]").getText();
      String Actual = "complete Assignments";
      Assert.assertEquals(Actual, expected);
      System.out.println("Notes added: "+ Actual);
      
      }
  
  @AfterClass
  	  public void tearDown() {
	        driver.quit();
  }

}
