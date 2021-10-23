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

public class Activity1 {
	 WebDriverWait wait;
	 AppiumDriver<MobileElement> driver = null;
 
  @BeforeClass
  public void setup() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "PixelEmulator");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 10);
      
      System.out.println("Open google tasks");
      Thread.sleep(8000);
	  
      
	  
  }

  @Test
  public void listofactivities() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  
      System.out.println("Google tasks app is open");
      Thread.sleep(2000);
      //first task
      MobileElement plus = driver.findElementByAccessibilityId("Create new task");
      plus.click();
	  Thread.sleep(5000);
	  MobileElement addtask1 = driver.findElementById("add_task_title");
	  addtask1.click();
	  Thread.sleep(3000); 
	  addtask1.sendKeys("Complete Activity with Google Tasks");
	  Thread.sleep(2000);
	  driver.findElementById("add_task_done").click();
	  Thread.sleep(6000);
	  //assertion
      String task1 = driver.findElementById("task_name").getText();
	  Assert.assertEquals(task1, "Complete Activity with Google Tasks");
	  System.out.println(task1);
	  
	  //second task
	  Thread.sleep(3000);
	  plus.click();
	  Thread.sleep(5000);
	  MobileElement addtask2 = driver.findElementById("add_task_title");
	  addtask2.click();
	  Thread.sleep(3000); 
	  addtask2.sendKeys("Complete Activity with Google Keep");
	  Thread.sleep(2000);
	  driver.findElementById("add_task_done").click();
	  Thread.sleep(6000);
      String task2 = driver.findElementById("task_name").getText();
	  Assert.assertEquals(task2, "Complete Activity with Google Keep");
	  System.out.println(task2);
	  
	  //third task
	  plus.click();
	  Thread.sleep(5000);
	  MobileElement addtask3 = driver.findElementById("add_task_title");
	  addtask3.click();
	  Thread.sleep(2000);
	  addtask3.sendKeys("Complete the second Activity Google Keep");
	  Thread.sleep(3000);
	  driver.findElementById("add_task_done").click();
	  Thread.sleep(3000);
	  String task3 = driver.findElementById("task_name").getText();
	  Assert.assertEquals(task3, "Complete the second Activity Google Keep");
	  System.out.println(task3);
	  
	    
	  
	  
  }
  
  @AfterClass
  	  public void tearDown() {
	        driver.quit();
  }

}
