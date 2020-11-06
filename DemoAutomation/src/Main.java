import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {
	WebDriver driver;
	POMHomePage homepage;
	POMLoginPage loginpage;
  @BeforeTest
  private void setup() {
	  System.setProperty("webdriver.chrome.driver","E:\\Web automation\\chromedriver_win32\\chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");

  }
  
  @Test
  public void testHomePage() throws InterruptedException {
	
	  homepage= new POMHomePage(driver);
	  loginpage= new POMLoginPage(driver);
	  loginpage.typeEmailId("standard_user");
	  Thread.sleep(2000);
	  loginpage.typePassword("secret_sauce");
	  Thread.sleep(2000);
	  loginpage.clickSignIn();
	  Thread.sleep(6000);
	  Assert.assertTrue(homepage.getButton());


  }
  @AfterTest
  public void teardown() {
	  driver.quit();
  }
}
