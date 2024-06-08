package Naukrii;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class Functional_Testing {
	WebDriver driver;
  @Test
  public void functional() throws InterruptedException {
	  try {
	  // all webelemnts are locator of Dynamic Xpath
	  driver.findElement(By.xpath("//input[@placeholder=\"Enter skills / designations / companies\"]")).sendKeys("Automation Testing");
	  driver.findElement(By.xpath("//span[@class=\"dropArrowDD\"]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//span[text()=\"3 years\"]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@placeholder=\"Enter location\"]")).sendKeys("Pune");
	  Thread.sleep(1000);
	  
	  //validating sesrch button is enable or not
	  WebElement search = driver.findElement(By.xpath("//div[text()=\"Search\"]"));
	  if(search.isEnabled()) {
	  driver.findElement(By.xpath("//div[text()=\"Search\"]")).click();
	  }
	  else {
		  System.out.println("Search button is not enable");
	  }
	  Thread.sleep(1000);
	  //Adding multiple 
	  driver.findElement(By.xpath("//span[@class=\"nI-gNb-sb__placeholder nI-gNb-sb__placeholder--prefill\"]")).click();
	  driver.findElement(By.xpath("//input[@placeholder=\"Enter keyword / designation / companies\"]")).sendKeys("Amazon");
	  driver.findElement(By.xpath("//input[@placeholder=\"Enter location\"]")).sendKeys("Hyderabad");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//span[text()=\"Search\"]")).click();
	  
	  //check the login button and register button is displayed or not
	  
	  WebElement login = driver.findElement(By.xpath("//a[text()=\"Login\"]"));
	  WebElement register = driver.findElement(By.xpath("//a[text()=\"Register\"]"));
	  if(login.isEnabled()) {
		  System.out.println("Login botton is Enable");
	  }
	  else {
		  System.out.println("Login buttons are not enable");
	  }
	  if(register.isEnabled()) {
		  System.out.println("Register botton is Enable");
	  }
	  else {
		  System.out.println("Register buttons are not enable");
	  }
	  }
	  catch(NoSuchElementException e) {
		  System.out.println("WebElemnts are get an error");
	  }
	  
  }
  @BeforeClass
  public void beforeClass() {
	  driver = WebDriverManager.chromedriver().create();
	  String url = "https://www.naukri.com/";
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
